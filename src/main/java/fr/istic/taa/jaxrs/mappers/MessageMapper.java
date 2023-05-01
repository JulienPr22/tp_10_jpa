package fr.istic.taa.jaxrs.mappers;

import fr.istic.taa.jaxrs.domain.Message;
import fr.istic.taa.jaxrs.dto.MessageDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MessageMapper {
    public static MessageDTO messageToMessageDTO(Message m) {
        MessageDTO messageDTO = new MessageDTO();
       messageDTO.setId(m.getId());
        messageDTO.setSenderId(m.getSender().getId());
        messageDTO.setRelatedTicketId(m.getRelatedTicket().getId());
        messageDTO.setContent(m.getContent());
        messageDTO.setDate(m.getDate());
        return messageDTO;
    }

    public static List<MessageDTO> messageListToMessageDtoList(List<Message> messageList) {
        return messageList.stream().map(MessageMapper::messageToMessageDTO).collect(Collectors.toList());
    }
}

