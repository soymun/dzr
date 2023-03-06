package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.Ticket.TicketCreateDto;
import com.example.dzr.DTO.Ticket.TicketDto;
import com.example.dzr.DTO.Ticket.TicketTrainDto;
import com.example.dzr.Entity.Place;
import com.example.dzr.Entity.Ticket;
import com.example.dzr.Exception.NotFoundException;
import com.example.dzr.Mapper.TicketMapper;
import com.example.dzr.Repository.PlaceRepository;
import com.example.dzr.Repository.TicketRepository;
import com.example.dzr.Service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TicketServiceImp implements TicketService {

    private final PlaceRepository placeRepository;
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Override
    @Transactional
    public TicketDto saveTicket(TicketCreateDto ticketCreateDto) {
        log.info("Сохранение билета польсозавтеля с id {}", ticketCreateDto.getPersonId());
        Ticket ticket = ticketMapper.ticketCreateDtoToTicket(ticketCreateDto);
        Place place = placeRepository.findById(ticket.getPlaceId()).orElseThrow(() -> {
            throw new NotFoundException(String.format("Место с id %d не найдено",ticket.getPlaceId()));
        });
        place.setBusy(true);
        placeRepository.save(place);
        return ticketMapper.ticketToTicketDto(ticketRepository.save(ticket));
    }

    @Override
    @Transactional
    public void deleteTicket(Long id) {
        log.info("Удаление билета пользователя с id {}", id);
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("Билет с id %d не найден",id));
        });
        Place place = placeRepository.findById(ticket.getPlaceId()).orElseThrow(() -> {
            throw new NotFoundException(String.format("Место с id %d не найдено",ticket.getPlaceId()));
        });
        place.setBusy(false);
        placeRepository.save(place);
        ticketRepository.deleteById(id);
    }

    @Override
    public List<TicketTrainDto> getTicketByTrainId(Long id) {
        log.info("Выдача билетов по id {} поезда", id);
        return ticketRepository.getTicketsByTrainId(id).stream()
                .map(ticketMapper::ticketToTicketTrainDto)
                .toList();
    }

    @Override
    public List<TicketDto> getTicketByUserId(Long id) {
        log.info("Выдача билетов по id {} пользователя", id);
        return ticketRepository.getTicketsByPersonId(id).stream()
                .map(ticketMapper::ticketToTicketDto)
                .toList();
    }
}
