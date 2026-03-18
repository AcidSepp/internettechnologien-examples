package de.haw.landshut.itt.rest;

import de.haw.landshut.itt.rest.pojo.UserWithId;
import de.haw.landshut.itt.rest.users.UserDatabaseService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserRestControllerTest {

// snippet: getUser_userFound_200
    @Test
    void getUser_userFound_200() {
        final var mock = mock(UserDatabaseService.class);
        final var testUser  //
                = new UserWithId("harald", "harald@schmitt.de", "my-id");
        when(mock.readUser("my-id")).thenReturn(testUser);

        final var userRestController = new UserRestController(mock);
        final var userResponse = userRestController.getUser("my-id");
        assertEquals(HttpStatus.OK, userResponse.getStatusCode());
        assertSame(testUser, userResponse.getBody());
    }
// snippet: /getUser_userFound_200


// snippet: getUser_userNotFound_404
    @Test
    void getUser_userNotFound_404() {
        final var mock = mock(UserDatabaseService.class);

        final var userRestController = new UserRestController(mock);
        final var userResponse = userRestController.getUser("my-id");
        assertEquals(HttpStatus.NOT_FOUND, userResponse.getStatusCode());
        assertNull(userResponse.getBody());
    }
// snippet: /getUser_userNotFound_404

}