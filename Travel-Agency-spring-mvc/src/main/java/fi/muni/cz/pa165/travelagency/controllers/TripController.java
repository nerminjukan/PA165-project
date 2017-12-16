package fi.muni.cz.pa165.travelagency.controllers;

import fi.muni.cz.pa165.travelagency.dto.ExcursionDTO;
import fi.muni.cz.pa165.travelagency.dto.TripCreateDTO;
import fi.muni.cz.pa165.travelagency.dto.TripDTO;
import fi.muni.cz.pa165.travelagency.entity.Excursion;
import fi.muni.cz.pa165.travelagency.facade.ExcursionFacade;
import fi.muni.cz.pa165.travelagency.facade.TripFacade;
import fi.muni.cz.pa165.travelagency.forms.TripCreateDTOValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Pavel Kotala
 */
@Controller
@RequestMapping("/trip")
public class TripController {

    final static Logger LOGGER = LoggerFactory.getLogger(TripController.class);

    @Autowired
    private TripFacade tripFacade;

    @Autowired
    private ExcursionFacade excursionFacade;

    /**
     * Shows a list of products with the ability to add, delete or edit.
     *
     * @param model data to display
     * @return JSP page name
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("trips", tripFacade.getAllTrips());
        return "trip/list";
    }

    /**
     * Deletes trip with given trip
     * @param id id of trip to delete
     * @param model model
     * @param uriBuilder uri builder
     * @param redirectAttributes redirect attributes
     * @return jsp page name
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, Model model, UriComponentsBuilder uriBuilder, RedirectAttributes redirectAttributes) {
        TripDTO trip = tripFacade.getTripWithId(id);
        tripFacade.deleteTrip(id);
        LOGGER.debug("delete({})", id);
        redirectAttributes.addFlashAttribute("alert_success", "Product \"" + trip.getName() + "\" was deleted.");
        return "redirect:" + uriBuilder.path("/trip/list").toUriString();
    }

    /**
     * Shows trip with given id
     * @param id id of trip to show
     * @param model model
     * @return jsp page name
     */
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable long id, Model model) {
        LOGGER.debug("view({})", id);
        model.addAttribute("trip", tripFacade.getTripWithId(id));
        return "product/view";
    }

    /**
     * Prepares an empty form.
     *
     * @param model data to be displayed
     * @return JSP page
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newProduct(Model model) {
        LOGGER.debug("new()");
        model.addAttribute("tripCreate", new TripCreateDTO());
        return "trip/new";
    }

    @ModelAttribute("excursions")
    public List<ExcursionDTO> excursions() {
        LOGGER.debug("excursions()");
        return excursionFacade.getAllExcursions();
    }

    /**
     * Spring Validator added to JSR-303 Validator for this @Controller only.
     * It is useful  for custom validations that are not defined on the form bean by annotations.
     * http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-mvc-configuring
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof TripCreateDTO) {
            binder.addValidators(new TripCreateDTOValidator());
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("tripCreate") TripCreateDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        LOGGER.debug("create(tripCreate={})", formBean);
        //in case of validation error forward back to the the form
        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                LOGGER.trace("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
                LOGGER.trace("FieldError: {}", fe);
            }
            return "trip/new";
        }
        //create trip
        Long id = tripFacade.createTrip(formBean);
        //report success
        redirectAttributes.addFlashAttribute("alert_success", "Trip " + id + " was created");
        return "redirect:" + uriBuilder.path("/trip/view/{id}").buildAndExpand(id).encode().toUriString();
    }
}

