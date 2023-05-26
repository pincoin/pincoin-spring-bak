package kr.pincoin.api.user.controller;

import kr.pincoin.api.home.dto.PageResponse;
import kr.pincoin.api.user.domain.User;
import kr.pincoin.api.user.dto.UserResponse;
import kr.pincoin.api.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<PageResponse<List<UserResponse>>>
    userList(@RequestParam(name = "active", required = false) Boolean active,
             Pageable pageable) {
        Page<User> page = userService.listUsers(active, pageable);
        return ResponseEntity.ok().body(new PageResponse<>(page.getTotalElements(),
                                                           page.getContent()
                                                                   .stream()
                                                                   .map(UserResponse::new)
                                                                   .toList()));
    }
}
