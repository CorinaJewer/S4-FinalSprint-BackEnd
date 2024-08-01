package com.keyin.Activity_Booking;
import com.keyin.Activities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class Activity_BookingController {

    @Autowired
    private Activity_Booking_Repository activityBookingRepository;
    @Autowired
    private Activity_BookingService activityBookingService;

    @PostMapping("/activities/book")
    public Activity_Booking createActivityBooking(@RequestBody Activity_BookingEntryDTO request){
        Long user_id = request.getUserId();
        Long activity_id = request.getActivityId();
        LocalDate date = request.getDate();
        return activityBookingService.createActivityBooking(user_id, activity_id, date);
    }

    @GetMapping("/activities/bookings/{activity_booking_id}")
    public Activity_Booking getActivityBookingById(@PathVariable Long activity_booking_id){
        return activityBookingService.getActivityBookingById(activity_booking_id);
    }

    @GetMapping("/activities/bookings/user/{user_id}")
        public List <Activity_Booking> getActivityBookingsByUserId(@PathVariable Long user_id){
        return activityBookingService.getActivityBookingsByUserId(user_id);
    }

    @GetMapping("/activities/bookings/activity/{activity_id}")
    public List <Activity_Booking> getActivityBookingsByActivityId(@PathVariable Long activity_id){
        return activityBookingService.getActivityBookingsByActivityId(activity_id);
    }

    @GetMapping("/activities/{activity_id}/availability")
    public boolean checkActivityAvailability(@PathVariable Long activity_id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return activityBookingService.checkAvailabilityByActivityId(activity_id, date);
    }

    @GetMapping("/activities/availability/all")
    public List <Activity> checkAllActivityAvailability(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return activityBookingService.checkAllActivityAvailability(date);
    }
}
