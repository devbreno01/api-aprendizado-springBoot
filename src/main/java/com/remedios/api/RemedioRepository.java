package com.remedios.api;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<Remedio, Long> { //Remedio é a instancia do remedio sendo passada com id, e o long referencia o tipo do id


}
