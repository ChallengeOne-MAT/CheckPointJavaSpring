package br.com.projeto.checkpointjava.controller;

import br.com.projeto.checkpointjava.dto.FeedbackDTO;
import br.com.projeto.checkpointjava.entity.Feedback;
import br.com.projeto.checkpointjava.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public Feedback criar(@RequestBody FeedbackDTO dto) {
        return feedbackService.criar(dto);
    }

    @GetMapping
    public List<Feedback> listar() {
        return feedbackService.listar();
    }

    @GetMapping("/{id}")
    public Feedback buscarPorId(@PathVariable Long id) {
        return feedbackService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        feedbackService.deletar(id);
    }
}
