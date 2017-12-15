package fi.muni.cz.pa165.travelagency.service;

import fi.muni.cz.pa165.travelagency.dto.UserDTO;
import fi.muni.cz.pa165.travelagency.entity.User;
import fi.muni.cz.pa165.travelagency.service.config.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Martin Sevcik
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class BeanMappingServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private BeanMappingService beanMappingService;

    private User user1, user2;
    private UserDTO userDTO1, userDTO2;
    private List<User> userList;
    private List<UserDTO> userDTOList;

    @BeforeMethod
    public void setup() {
        Calendar cal = Calendar.getInstance();

        user1 = new User();
        user1.setEmail("email1@email.com");
        user1.setIdCardNumber("idCardNumber1");
        user1.setName("Name1");
        user1.setSurname("Surname1");
        user1.setPhoneNumber("78945561231");
        cal.set(2017, 28, 10);
        user1.setBirthDate(cal.getTime());

        user2 = new User();
        user2.setEmail("email2@email.com");
        user2.setIdCardNumber("idCardNumber2");
        user2.setName("Name2");
        user2.setSurname("Surname2");
        user2.setPhoneNumber("78945561232");
        cal.set(2017, 29, 10);
        user2.setBirthDate(cal.getTime());

        userDTO1 = new UserDTO();
        userDTO1.setEmail("email1@email.com");
        userDTO1.setIdCardNumber("idCardNumber1");
        userDTO1.setName("Name1");
        userDTO1.setSurname("Surname1");
        userDTO1.setPhoneNumber("78945561231");
        cal.set(2017, 28, 10);
        userDTO1.setBirthDate(cal.getTime());

        userDTO2 = new UserDTO();
        userDTO2.setEmail("email2@email.com");
        userDTO2.setIdCardNumber("idCardNumber2");
        userDTO2.setName("Name2");
        userDTO2.setSurname("Surname2");
        userDTO2.setPhoneNumber("78945561232");
        cal.set(2017, 29, 10);
        userDTO2.setBirthDate(cal.getTime());

        userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        userDTOList = new ArrayList<>();
        userDTOList.add(userDTO1);
        userDTOList.add(userDTO2);
    }

    @Test
    public void testMapping2UserEntityList() {
        List<User> userMappedList = beanMappingService.mapTo(userDTOList, User.class);
        userEqualsTest(userMappedList.get(0), user1);
        userEqualsTest(userMappedList.get(1), user2);
    }

    @Test
    public void testMapping2UserDTOEntityList() {
        List<UserDTO> userMappedList = beanMappingService.mapTo(userList, UserDTO.class);
        userEqualsDTOTest(userMappedList.get(0), userDTO1);
        userEqualsDTOTest(userMappedList.get(1), userDTO2);
    }

    @Test
    public void testMapping2UserEntity() {
        User found = beanMappingService.mapTo(userDTO1, User.class);
        userEqualsTest(found, user1);
    }

    @Test
    public void testMapping2UserDTOEntity() {
        UserDTO foundDTO = beanMappingService.mapTo(user1, UserDTO.class);
        userEqualsDTOTest(foundDTO, userDTO1);
    }

    public void userEqualsTest(User userNew, User userExpected) {
        Assert.assertEquals(userNew.getIdCardNumber(), userExpected.getIdCardNumber(),"IdCardNumber Equality");
        Assert.assertEquals(userNew.getSurname(), userExpected.getSurname(), "Surname Equality");
        Assert.assertEquals(userNew.getName(), userExpected.getName(), "Name Equality");
        Assert.assertEquals(userNew.getReservations(), userExpected.getReservations(), "Reservations Equality");
        Assert.assertEquals(userNew.getPhoneNumber(), userExpected.getPhoneNumber(), "PhoneNumber Equality");
        Assert.assertEquals(userNew.getBirthDate(), userExpected.getBirthDate(), "BirthDate Equality");
        Assert.assertEquals(userNew.getEmail(), userExpected.getEmail(), "Email Equality");
    }

    public void userEqualsDTOTest(UserDTO userDTONew, UserDTO userDTOExpected) {
        Assert.assertEquals(userDTONew.getIdCardNumber(), userDTOExpected.getIdCardNumber(),"IdCardNumber Equality");
        Assert.assertEquals(userDTONew.getSurname(), userDTOExpected.getSurname(), "Surname Equality");
        Assert.assertEquals(userDTONew.getName(), userDTOExpected.getName(), "Name Equality");
        Assert.assertEquals(userDTONew.getReservations(), userDTOExpected.getReservations(), "Reservations Equality");
        Assert.assertEquals(userDTONew.getPhoneNumber(), userDTOExpected.getPhoneNumber(), "PhoneNumber Equality");
        Assert.assertEquals(userDTONew.getBirthDate(), userDTOExpected.getBirthDate(), "BirthDate Equality");
        Assert.assertEquals(userDTONew.getEmail(), userDTOExpected.getEmail(), "Email Equality");
    }
}
