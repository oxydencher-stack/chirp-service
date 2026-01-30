package ru.parus.chirp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import ru.parus.chirp.model.dto.post.PostDto;
import ru.parus.chirp.service.PostService;

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

    private final PostService postService;

    @PostMapping("/")
    public ResponseEntity<PostDto> create(@RequestBody PostDto dto) {
        return ResponseEntity.ok(postService.create(dto));
    }

    @GetMapping("/")
    public ResponseEntity<Page<PostDto>> index(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(postService.index(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> show(@PathVariable Long id) {
        return ResponseEntity.ok(postService.show(id));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<PostDto> update(@PathVariable Long id, @RequestBody PostDto dto) {
        return ResponseEntity.ok(postService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
