package de.haw.landshut.itt.rest.users;

import de.haw.landshut.itt.rest.pojo.User;
import de.haw.landshut.itt.rest.pojo.UserWithId;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

// snippet: service
@Service
public class UserDatabaseService {
// snippet: /service

    public UserDatabaseService() {
        userHashMap.put("1", new UserWithId("alice", "alice@haw-landshut.de", "1"));
    }

    private final HashMap<String, UserWithId> userHashMap = new HashMap<>();

    public UserWithId createUser(final User user) {
        final var uuid = UUID.randomUUID().toString();
        userHashMap.put(uuid, new UserWithId(user.name(), user.email(), uuid));
        return userHashMap.get(uuid);
    }

    public UserWithId readUser(final String uuid) {
        return userHashMap.get(uuid);
    }

    public List<UserWithId> listUsers() {
        return userHashMap.entrySet().stream()
                .map((it) -> new UserWithId(it.getValue().name(), it.getValue().email(), it.getKey()))//
                .toList();
    }

    public UserWithId updateUser(final String uuid, final User user) {
        final var userWithId = new UserWithId(user.name(), user.email(), uuid);
        final var put = userHashMap.put(uuid, userWithId);
        if (put != null) {
            return userHashMap.get(uuid);
        }
        return null;
    }

    public UserWithId deleteUser(final String uuid) {
        final var put = userHashMap.remove(uuid);
        if (put != null) {
            return new UserWithId(put.name(), put.email(), uuid);
        }
        return null;
    }
}
