package ru.parus.chirp.controller;

import java.awt.print.Pageable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PostController
 * <p>
 *     Контроллер для работы с постами пользователей
 * </p>
 *
 * @author Grachev.D.G  (zhulvern-92@mail.ru)
 * @version 27.01.2026
 */
@Slf4j
@RestController
@RequestMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PostController {

    @PostMapping("/")
    public ResponseEntity<Object> create() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<Page<Object>> index(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page<Object>> show(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

}
