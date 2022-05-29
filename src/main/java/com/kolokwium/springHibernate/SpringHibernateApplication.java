package com.kolokwium.springHibernate;

import com.kolokwium.springHibernate.game.models.GameEntity;
import com.kolokwium.springHibernate.game.models.Location;
import com.kolokwium.springHibernate.game.models.LocationType;
import com.kolokwium.springHibernate.game.repository.GameDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class SpringHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateApplication.class, args);
	}

	@Autowired
	GameDatabaseRepository gameDatabaseRepository;
	@PostConstruct
	public void generator(){
		gameDatabaseRepository.save(new GameEntity(
				"Uther",80,"paladin",6000,46432, LocationType.TOWN,
				Collections.singletonList(new Location("Stormwind"))
		));
		gameDatabaseRepository.save(new GameEntity(
				"Jaina",95,"Mage",10000,12394, LocationType.TOWN,
				Collections.singletonList(new Location("Stormwind"))
		));
		gameDatabaseRepository.save(new GameEntity(
				"Rexxar",90,"Archer",9000,3245, LocationType.TOWN,
				Collections.singletonList(new Location("Stormwind"))
		));
		gameDatabaseRepository.save(new GameEntity(
				"Illidan",99,"demon_hunter",15000,8012, LocationType.DUNGEON,
				Collections.singletonList(new Location("NAXRAMAAS"))
		));
	}

}
/*
Zadanie na kolokwium:
Wymyśl dowolny mini program do zapisu i odczytu danych.
Na przykład program auto, który będzie zapisywał auta i relacje między nimi itd. (To tylko przykład proszę go nie wykorzystywać i wymyślić własny)

Program przetestuj postmanem i do kodu załącz screeny, że działa.
Prace przesyłanie do mnie w prywatnej wiadomości na MS Teams.

Spring:
1. Stwórz prosty rest kontroler, obsługujący metody http get/post/put/delete
2. Stwórz spring data repository, repozytorium ma zawierać przynajmniej 3 różne metody do filtrowania na bazie po polach encji.
3. Stwórz serwis, pośredniczący pomiędzy kontrolerem a repozytorium.
4. Stwórz przynajmniej jeden bean własnego typu, który wstrzykniesz do serwisu.
5. Niech serwis będzie transakcyjny.

Hibernate:
1. Stwórz prostą encję, niech ma przynajmniej 5 pól.
2. Niech encja posiada enum, który będzie zapisywał się na bazie jako varchar (string).
3. Niech encja posiada zagnieżdżony obiekt lub listę obiektów.
4. Niech encja będzie w relacji z inną encją (dowolna z 3 dostępnych relacji, ale musi mięć sens)
TODO 5. Niech encja wykorzysta dziedziczenie na bazie danych.)

 */
