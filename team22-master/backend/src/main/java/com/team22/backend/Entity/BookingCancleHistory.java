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
@Table(name="BookingCancleHistory")
public class BookingCancleHistory {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="bookingcanclehistory_seq",sequenceName="bookingcanclehistory_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bookingcanclehistory_seq")
    @Column(name="BookingCancleHistoryID",unique = true, nullable = false)
    private @NonNull Long bookingCancleHistoryID;
}