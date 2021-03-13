package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Slot;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findAllByDoctorAndDateOrderByTimeBeginAsc(Doctor doctor, LocalDate date);
    List<Slot> findAllByDoctorAndIsAvailableAndDateOrderByTimeBeginAsc(Doctor doctor, boolean isAvailable,LocalDate date);
    Long countByDoctorAndDate(Doctor doctor, LocalDate date);
    Long countByDoctorAndIsAvailableAndDate(Doctor doctor, boolean isAvailable,LocalDate date);
    Long countByDoctorSpecialityNameAndDate(String specialityName, LocalDate date);
    Long countByDoctorSpecialityNameAndIsAvailableAndDate(String specialityName, boolean isAvailable, LocalDate date);
    Slot findBySlotId(Long slotId);
}
