package co.grandcircus.Capstone_6.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Capstone_6.Entities.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

	List<Task> findByUserId(Long id);
}
