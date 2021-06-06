package com.lamzone.Mareu.meeting.participant;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("api/v1/participants")
@AllArgsConstructor
public class ParticipantController {

    private final ParticipantService service;
    private final ParticipantModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Participant>> allParticipant() {
        return assembler.toCollectionModel(service.allParticipants());
    }

    @GetMapping("/{id}")
    public EntityModel<Participant> one(@PathVariable Long id) {
        return assembler.toModel(service.one(id));
    }

    @PostMapping
    public ResponseEntity<EntityModel<Participant>> newParticipant(@RequestBody Participant participant){
        EntityModel<Participant> participantEntityModel = assembler.toModel(service.newParticipant(participant));
        return ResponseEntity
                .created(participantEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(participantEntityModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParticipant(@PathVariable Long id) {
        service.deleteParticipant(id);
        return ResponseEntity.noContent().build();
    }
}
