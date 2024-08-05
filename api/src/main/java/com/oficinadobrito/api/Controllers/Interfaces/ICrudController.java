package com.oficinadobrito.api.Controllers.Interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface ICrudController<T,TCreateDto,TUpdateDto> {
    ResponseEntity<List<T>> getAllResource();
    ResponseEntity<T> postResource(@RequestBody TCreateDto resource);
    ResponseEntity<T> updateResource(@PathVariable("id") long id, @RequestBody TUpdateDto resource);
    ResponseEntity<Void> deleteResourceById(@PathVariable("id") long id);
    ResponseEntity<T> getResourceById(@PathVariable("id") long id);
}
