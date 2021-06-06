package com.lamzone.Mareu.meeting.participant;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ParticipantModelAssembler implements RepresentationModelAssembler<Participant, EntityModel<Participant>> {
    @Override
    public EntityModel<Participant> toModel(Participant participant) {
        return EntityModel.of(
                participant,
                linkTo(methodOn(ParticipantController.class).one(participant.getParticipantId())).withSelfRel(),
                linkTo(methodOn(ParticipantController.class).allParticipant()).withRel("participants")
        );
    }

    @Override
    public CollectionModel<EntityModel<Participant>> toCollectionModel(Iterable<? extends Participant> entities) {
        CollectionModel<EntityModel<Participant>> entityModels = RepresentationModelAssembler.super.toCollectionModel(entities);
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
