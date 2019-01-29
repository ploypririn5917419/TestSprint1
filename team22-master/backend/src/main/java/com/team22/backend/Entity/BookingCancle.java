package com.team22.backend.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="BookingCancle")
public class BookingCancle {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="bookingcancle_seq",sequenceName="bookingcancle_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bookingcancle_seq")
    @Column(name="BookingCancleID",unique = true, nullable = false)
    private @NonNull Long bookingCancleID;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Booking.class)
    @JoinColumn(name = "bookingId", insertable = true)
    private Booking Booking;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = BookingCancleHistory.class)
    @JoinColumn(name = "bookingCancleHistoryID", insertable = true)
    private BookingCancleHistory BookingCancleHistory;

}