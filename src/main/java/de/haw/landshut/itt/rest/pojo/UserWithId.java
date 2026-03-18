package de.haw.landshut.itt.rest.pojo;

import jakarta.validation.constraints.NotEmpty;

public record UserWithId(@NotEmpty(message = "'name' is required") String name,
                         @NotEmpty(message = "'email' is required") String email,
                         @NotEmpty(message = "'id' is required") String id) {
}
