package de.haw.landshut.itt.rest.pojo;

import jakarta.validation.constraints.NotEmpty;

// snippet: user
public record User(@NotEmpty(message = "'name' is required") String name,
                   @NotEmpty(message = "'email' is required") String email) {
}
// snippet: /user

