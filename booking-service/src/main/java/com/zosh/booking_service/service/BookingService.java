package com.zosh.booking_service.service;

import com.zosh.booking_service.domain.BookingStatus;
import com.zosh.booking_service.dto.*;
import com.zosh.booking_service.entity.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingService {
    Booking createBooking(BookingRequest bookingRequest, SalonDTO salonDTO, UserDTO userDTO,
                          Set<ServiceDTO> serviceDTOs);

    List<Booking> getBookingByCustomer(Long customerId);
    List<Booking> getBookingBySalon(Long salonId);
    Booking getBookingById(Long bookingId);
    Booking updateBooking(Long bookingId, BookingStatus bookingStatus);
    List<Booking> getBookingByDate(LocalDate date,Long salonId);
    SalonReport getSalonReport(Long salonId);
}
