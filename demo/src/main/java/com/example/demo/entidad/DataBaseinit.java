package com.example.demo.entidad;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.MascotaRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DataBaseinit implements ApplicationRunner{

    @Autowired
    ClienteRepository client_repo;

    @Autowired
    MascotaRepository mascota_repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        client_repo.save(new Cliente(123456, "Gabriel Mora", "morita@gmail.com", 896547));
        client_repo.save(new Cliente(9876543, "Eladio Carrion", "ela.god@gmail.com", 546791));
        client_repo.save(new Cliente(753124, "Benito Antonio", "BadBunny@gmail.com", 749685));
        client_repo.save(new Cliente(741258, "Diomedes Diaz", "diomedesdays@gmail.com", 349761));
        client_repo.save(new Cliente(852123, "Kaleth Morales", "KaLimbo@gmail.com", 412398));
        client_repo.save(new Cliente(6523987, "Silvestre Dangond", "WinniePooh@gmail.com", 987201));
        client_repo.save(new Cliente(12345678, "Henry Cavill", "cavillHenry@gmail.com", 321567885));
        client_repo.save(new Cliente(456123, "Lana Del Rey", "lana.delrey@gmail.com", 658124));
        client_repo.save(new Cliente(234567, "Rosalía Vila", "rosalia.vila@gmail.com", 321654));
        client_repo.save(new Cliente(987654, "Sebastián Yatra", "yatra.sebas@gmail.com", 875412));
        client_repo.save(new Cliente(654789, "Shakira Mebarak", "shaki@gmail.com", 963258));
        client_repo.save(new Cliente(321654, "Rauw Alejandro", "rauw.alejandro@gmail.com", 784512));
        client_repo.save(new Cliente(963852, "Karol G", "karolg@gmail.com", 654123));
        client_repo.save(new Cliente(159753, "Nicky Jam", "nicky.jam@gmail.com", 258741));
        client_repo.save(new Cliente(258741, "Marc Anthony", "marc.anthony@gmail.com", 951753));
        client_repo.save(new Cliente(852369, "Maluma", "maluma.baby@gmail.com", 741852));
        client_repo.save(new Cliente(753951, "J Balvin", "balvin.j@gmail.com", 852741));
        client_repo.save(new Cliente(456852, "Ozuna", "ozuna@gmail.com", 369852));
        client_repo.save(new Cliente(654321, "Daddy Yankee", "daddy.yankee@gmail.com", 789456));
        client_repo.save(new Cliente(741852, "Anuel AA", "anuel.aa@gmail.com", 987654));
        client_repo.save(new Cliente(987123, "Natti Natasha", "natti.natasha@gmail.com", 654789));
        client_repo.save(new Cliente(789456, "Tini Stoessel", "tini@gmail.com", 456123));
        client_repo.save(new Cliente(852741, "Becky G", "beckyg@gmail.com", 123789));
        client_repo.save(new Cliente(369852, "Camila Cabello", "camila.cabello@gmail.com", 654321));
        client_repo.save(new Cliente(456123, "Luis Fonsi", "fonsi@gmail.com", 741258));
        client_repo.save(new Cliente(963741, "Ricky Martin", "ricky.martin@gmail.com", 852963));
        client_repo.save(new Cliente(753159, "Thalía", "thalia@gmail.com", 951357));
        client_repo.save(new Cliente(654789, "Enrique Iglesias", "enrique.iglesias@gmail.com", 159753));
        client_repo.save(new Cliente(741258, "Carlos Vives", "vives.carlos@gmail.com", 852963));
        client_repo.save(new Cliente(852963, "Juanes", "juanes@gmail.com", 753159));
        client_repo.save(new Cliente(951357, "Alejandro Sanz", "sanz.alejandro@gmail.com", 654852));
        client_repo.save(new Cliente(159753, "Pablo Alborán", "pablo.alboran@gmail.com", 321654));
        client_repo.save(new Cliente(258963, "Manuel Turizo", "turizo.manuel@gmail.com", 654789));
        client_repo.save(new Cliente(369852, "Sebastián Yatra", "sebastian.yatra@gmail.com", 789456));
        client_repo.save(new Cliente(456741, "Kany García", "kany.garcia@gmail.com", 852963));
        client_repo.save(new Cliente(123789, "Gloria Trevi", "gloria.trevi@gmail.com", 159753));
        client_repo.save(new Cliente(321654, "Chayanne", "chayanne@gmail.com", 456852));
        client_repo.save(new Cliente(987456, "David Bisbal", "david.bisbal@gmail.com", 753951));
        client_repo.save(new Cliente(741852, "Carlos Rivera", "carlos.rivera@gmail.com", 951357));
        client_repo.save(new Cliente(654963, "Alejandra Guzmán", "alejandra.guzman@gmail.com", 369852));
        client_repo.save(new Cliente(852741, "Paulina Rubio", "paulina.rubio@gmail.com", 456123));
        client_repo.save(new Cliente(951753, "Ricardo Arjona", "arjona@gmail.com", 963852));
        client_repo.save(new Cliente(123456, "Luis Miguel", "luismi@gmail.com", 321654));
        client_repo.save(new Cliente(987654, "Ana Gabriel", "ana.gabriel@gmail.com", 741852));
        client_repo.save(new Cliente(741852, "Juan Gabriel", "juangabriel@gmail.com", 852963));
        client_repo.save(new Cliente(369258, "José José", "josejose@gmail.com", 951357));
        client_repo.save(new Cliente(159753, "Vicente Fernández", "vicente.fernandez@gmail.com", 258963));
        client_repo.save(new Cliente(258963, "Joan Sebastian", "joan.sebastian@gmail.com", 654789));
        client_repo.save(new Cliente(753951, "José Alfredo Jiménez", "josealfredo@gmail.com", 741852));
        client_repo.save(new Cliente(951753, "Marco Antonio Solís", "marco.solis@gmail.com", 963852));
        client_repo.save(new Cliente(456852, "Julio Iglesias", "julio.iglesias@gmail.com", 321654));
        client_repo.save(new Cliente(852741, "Lupita D’Alessio", "lupita@gmail.com", 159753));
        client_repo.save(new Cliente(963852, "Amanda Miguel", "amanda.miguel@gmail.com", 456741));
        client_repo.save(new Cliente(369258, "Eros Ramazzotti", "eros.ramazzotti@gmail.com", 654852));
        client_repo.save(new Cliente(654789, "Laura Pausini", "laura.pausini@gmail.com", 987456));
        client_repo.save(new Cliente(741852, "Roberto Carlos", "roberto.carlos@gmail.com", 753951));
        client_repo.save(new Cliente(951753, "Caetano Veloso", "caetano.veloso@gmail.com", 654963));
        client_repo.save(new Cliente(159753, "Gal Costa", "gal.costa@gmail.com", 123789));
        client_repo.save(new Cliente(123789, "Milton Nascimento", "milton.nascimento@gmail.com", 741852));
        client_repo.save(new Cliente(963852, "Jorge Ben Jor", "jorge.benjor@gmail.com", 369258));
        client_repo.save(new Cliente(369258, "Gilberto Gil", "gilberto.gil@gmail.com", 159753));
        client_repo.save(new Cliente(753951, "Elis Regina", "elis.regina@gmail.com", 951753));
        client_repo.save(new Cliente(951753, "Chico Buarque", "chico.buarque@gmail.com", 456852));
        client_repo.save(new Cliente(456852, "João Gilberto", "joao.gilberto@gmail.com", 852741));
        client_repo.save(new Cliente(852741, "Antonio Carlos Jobim", "antonio.jobim@gmail.com", 654789));
        client_repo.save(new Cliente(123789, "Caetano Veloso", "caetano.veloso2@gmail.com", 741852));
        client_repo.save(new Cliente(963852, "Gilberto Gil", "gilberto.gil2@gmail.com", 951753));
        client_repo.save(new Cliente(741852, "Roberto Carlos", "roberto.carlos2@gmail.com", 159753));
        client_repo.save(new Cliente(654789, "Maria Bethânia", "maria.bethania@gmail.com", 369258));
        client_repo.save(new Cliente(123789, "Milton Nascimento", "milton.nascimento2@gmail.com", 654789));
        client_repo.save(new Cliente(369258, "Djavan", "djavan@gmail.com", 741852));
        client_repo.save(new Cliente(741852, "Gilberto Gil", "gilberto.gil3@gmail.com", 951753));
        client_repo.save(new Cliente(159753, "Elis Regina", "elis.regina2@gmail.com", 456852));
        client_repo.save(new Cliente(456852, "João Gilberto", "joao.gilberto2@gmail.com", 852741));
        client_repo.save(new Cliente(852741, "Antonio Carlos Jobim", "antonio.jobim2@gmail.com", 654789));
        client_repo.save(new Cliente(654789, "Roberto Carlos", "roberto.carlos3@gmail.com", 741852));
        client_repo.save(new Cliente(123789, "Caetano Veloso", "caetano.veloso3@gmail.com", 159753));
        client_repo.save(new Cliente(741852, "Maria Bethânia", "maria.bethania2@gmail.com", 369258));
        client_repo.save(new Cliente(159753, "Chico Buarque", "chico.buarque2@gmail.com", 654789));
        client_repo.save(new Cliente(369258, "Gal Costa", "gal.costa2@gmail.com", 951753));
        client_repo.save(new Cliente(951753, "Gilberto Gil", "gilberto.gil4@gmail.com", 456852));
        client_repo.save(new Cliente(456852, "Milton Nascimento", "milton.nascimento3@gmail.com", 852741));
        client_repo.save(new Cliente(852741, "Djavan", "djavan2@gmail.com", 654789));
        client_repo.save(new Cliente(123789, "Caetano Veloso", "caetano.veloso4@gmail.com", 159753));
        client_repo.save(new Cliente(741852, "Maria Bethânia", "maria.bethania3@gmail.com", 369258));
        client_repo.save(new Cliente(159753, "Chico Buarque", "chico.buarque3@gmail.com", 654789));
        client_repo.save(new Cliente(369258, "Elis Regina", "elis.regina3@gmail.com", 951753));
        client_repo.save(new Cliente(951753, "João Gilberto", "joao.gilberto3@gmail.com", 456852));
        client_repo.save(new Cliente(456852, "Antonio Carlos Jobim", "antonio.jobim3@gmail.com", 852741));
        client_repo.save(new Cliente(852741, "Roberto Carlos", "roberto.carlos5@gmail.com", 654789));
        client_repo.save(new Cliente(654789, "Caetano Veloso", "caetano.veloso5@gmail.com", 741852));
        client_repo.save(new Cliente(123123, "Selena Gomez", "selena.gomez@gmail.com", 789123));
        client_repo.save(new Cliente(321321, "Justin Bieber", "justin.bieber@gmail.com", 654789));
        client_repo.save(new Cliente(987987, "Ariana Grande", "ariana.grande@gmail.com", 852963));
        client_repo.save(new Cliente(654654, "Taylor Swift", "taylor.swift@gmail.com", 963741));
        client_repo.save(new Cliente(456456, "Ed Sheeran", "ed.sheeran@gmail.com", 741852));
        client_repo.save(new Cliente(789789, "Shawn Mendes", "shawn.mendes@gmail.com", 159753));
        client_repo.save(new Cliente(852852, "Billie Eilish", "billie.eilish@gmail.com", 258963));
        client_repo.save(new Cliente(963963, "Dua Lipa", "dua.lipa@gmail.com", 369852));

        mascota_repo.save(new Mascota("Luna", "Beagle", 3, 10.5f, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/1200px-Shemsu_Sotis_Perun.jpg"));
        mascota_repo.save(new Mascota("Max", "Golden Retriever", 5, 25.3f, "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09golden20retriever.jpg?itok=48StbVfe"));
        mascota_repo.save(new Mascota("Bella", "Bulldog Francés", 4, 12.7f, "https://picartpetcare.com/wp-content/uploads/2020/05/BULLDOG-FRANC%C3%89S.jpg"));
        mascota_repo.save(new Mascota("Charlie", "Labrador Retriever", 6, 30.2f, "https://pamipe.com/wiki/wp-content/uploads/2022/09/Labrador-Retriever.jpg"));
        mascota_repo.save(new Mascota("Lucy", "Poodle", 2, 8.4f, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me.%285898350017%29.jpg/640px-My_cousin%27s_poodle_is_perched_and_not_knowing_what_to_make_of_me.%285898350017%29.jpg"));
        mascota_repo.save(new Mascota("Rocky", "Boxer", 5, 28.9f, "https://cdn.royalcanin-weshare-online.io/ZT-S7XoBRYZmsWpc4beN/v9/bp-lot-2-boxer-bw-ws-2"));
        mascota_repo.save(new Mascota("Daisy", "Cocker Spaniel", 3, 14.1f, "https://blog-static.petlove.com.br/wp-content/uploads/2018/06/cocker-figado-tan.jpg"));
        mascota_repo.save(new Mascota("Cooper", "Border Collie", 4, 20.0f, "https://example.com/images/border_collie1.jpg"));
        mascota_repo.save(new Mascota("Molly", "Chihuahua", 3, 2.5f, "https://example.com/images/chihuahua1.jpg"));
        mascota_repo.save(new Mascota("Buddy", "Siberian Husky", 4, 22.8f, "https://example.com/images/siberian_husky1.jpg"));
        mascota_repo.save(new Mascota("Zoe", "Dachshund", 5, 9.8f, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRa3ewvi6qjaUE5Z87OXoKlxqHu83Tc8u5bnA&s"));
        mascota_repo.save(new Mascota("Bailey", "Shih Tzu", 2, 7.4f, "https://www.perro-obediente.com/blog/wp-content/uploads/2023/04/cachorro-shih-tzu-aislado-blanco_87557-18423.jpg"));
        mascota_repo.save(new Mascota("Oliver", "Pomerania", 3, 3.2f, "https://example.com/images/pomerania1.jpg"));
        mascota_repo.save(new Mascota("Sadie", "Bulldog Inglés", 4, 24.5f, "https://example.com/images/bulldog_ingles1.jpg"));
        mascota_repo.save(new Mascota("Toby", "Bichón Frisé", 5, 7.9f, "https://blog.mascotaysalud.com/wp-content/uploads/2020/03/Bich%C3%B3n-Fris%C3%A9-rostro.jpg"));
        mascota_repo.save(new Mascota("Sophie", "Pastor Alemán", 6, 28.7f, "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE"));
        mascota_repo.save(new Mascota("Bear", "Rottweiler", 4, 45.2f, "https://example.com/images/rottweiler1.jpg"));
        mascota_repo.save(new Mascota("Maggie", "Yorkshire Terrier", 3, 3.1f, "https://media.graphassets.com/output=format:webp/KHpTY4nvQMiNxkgNcfNm"));
        mascota_repo.save(new Mascota("Jack", "Pug", 5, 8.9f, "https://example.com/images/pug1.jpg"));
        mascota_repo.save(new Mascota("Chloe", "Caniche", 4, 4.8f, "https://example.com/images/caniche1.jpg"));
        mascota_repo.save(new Mascota("Duke", "Doberman", 5, 34.6f, "https://example.com/images/doberman1.jpg"));
        mascota_repo.save(new Mascota("Roxy", "Akita", 4, 32.7f, "https://example.com/images/akita1.jpg"));
        mascota_repo.save(new Mascota("Ruby", "Samoyedo", 4, 21.4f, "https://example.com/images/samoyedo1.jpg"));
        mascota_repo.save(new Mascota("Oscar", "Mastín", 5, 50.3f, "https://example.com/images/mastin1.jpg"));
        mascota_repo.save(new Mascota("Milo", "Pug", 3, 8.7f, "https://example.com/images/pug2.jpg"));
        mascota_repo.save(new Mascota("Rosie", "Chihuahua", 2, 2.3f, "https://example.com/images/chihuahua2.jpg"));
        mascota_repo.save(new Mascota("Lily", "Shih Tzu", 3, 7.2f, "https://static.wixstatic.com/media/aa8751_1aa95fd67b9e4f13850e5de823d7fb5c~mv2.jpg/v1/fill/w_736,h_1000,al_c,q_85,enc_auto/aa8751_1aa95fd67b9e4f13850e5de823d7fb5c~mv2.jpg"));
        mascota_repo.save(new Mascota("Gus", "Beagle", 4, 11.0f, "https://www.elmueble.com/medio/2023/03/02/perro-de-raza-beagle_67c65dda_230302133829_900x900.jpg"));
        mascota_repo.save(new Mascota("Bruno", "Labrador Retriever", 5, 30.8f, "https://example.com/images/labrador2.jpg"));
        mascota_repo.save(new Mascota("Ellie", "Cocker Spaniel", 3, 14.5f, "https://tierarzt-karlsruhe-durlach.de/storage/2024/04/Cocker-Spaniel-Krankheiten.webp"));
        mascota_repo.save(new Mascota("Finn", "Border Collie", 4, 20.4f, "https://example.com/images/border_collie2.jpg"));
        mascota_repo.save(new Mascota("Nala", "Boxer", 4, 27.9f, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.ecured.cu%2FB%25C3%25B3xer&psig=AOvVaw3zA5cq7cClKyJcvuBSc8Ug&ust=1725056714519000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCJCa4Jqfm4gDFQAAAAAdAAAAABAR"));
        mascota_repo.save(new Mascota("Louie", "Pomerania", 2, 3.4f, "https://example.com/images/pomerania2.jpg"));
        mascota_repo.save(new Mascota("Bentley", "Yorkshire Terrier", 3, 3.3f, "https://t1.uc.ltmcdn.com/es/posts/2/0/3/como_cuidar_a_un_yorkshire_terrier_40302_600_square.jpg"));
        mascota_repo.save(new Mascota("Willow", "Bulldog Inglés", 5, 23.5f, "https://example.com/images/bulldog_ingles2.jpg"));
        mascota_repo.save(new Mascota("Hazel", "Bichón Frisé", 2, 7.5f, "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-07Bichon20Frise1.jpg?itok=zexTRUzN"));
        mascota_repo.save(new Mascota("Thor", "Rottweiler", 4, 44.7f, "https://example.com/images/rottweiler2.jpg"));
        mascota_repo.save(new Mascota("Ranger", "Pastor Alemán", 5, 29.1f, "https://koalamascotas.com/img/cms/pastor%20alem%C3%A1n-1.jpg"));
        mascota_repo.save(new Mascota("Zoey", "Golden Retriever", 3, 24.9f, "https://example.com/images/golden_retriever2.jpg"));
        mascota_repo.save(new Mascota("Hunter", "Siberian Husky", 4, 23.5f, "https://example.com/images/siberian_husky2.jpg"));
        mascota_repo.save(new Mascota("Minnie", "Shih Tzu", 4, 7.6f, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Shih-Tzu.JPG/320px-Shih-Tzu.JPG"));
        mascota_repo.save(new Mascota("Rusty", "Cocker Spaniel", 5, 14.8f, "https://www.fanaticosdelasmascotas.cl/wp-content/uploads/2020/08/sabsykorova-Pixabay_portada.jpg"));
        mascota_repo.save(new Mascota("Marley", "Beagle", 3, 10.7f, "https://smylepets.com/wp-content/uploads/2021/03/Beagle.png"));
        mascota_repo.save(new Mascota("Leo", "Poodle", 2, 8.2f, "https://example.com/images/poodle2.jpg"));
        mascota_repo.save(new Mascota("Chorizo", "Dachshund", 3, 9.6f, "https://www.shutterstock.com/shutterstock/photos/721878286/display_1500/stock-photo-a-dog-puppy-of-the-dachshund-male-breed-black-and-tan-on-isolated-on-white-background-721878286.jpg"));
        mascota_repo.save(new Mascota("Ace", "Bulldog Francés", 4, 12.9f, "https://www.elespectador.com/resizer/v2/D5V6CAF62BCSHF63POA2X244KY.png?auth=b834db3fa7a919a6ca7a11aa199390e34ebeecde1a7cb04bb73dd7b071aa4733&width=1110&height=739&smart=true&quality=60"));
        mascota_repo.save(new Mascota("Ollie", "Golden Retriever", 5, 26.0f, "https://example.com/images/golden_retriever3.jpg"));
        mascota_repo.save(new Mascota("Harley", "Labrador Retriever", 4, 29.9f, "https://example.com/images/labrador3.jpg"));
        mascota_repo.save(new Mascota("Sam", "Pomerania", 3, 3.5f, "https://example.com/images/pomerania3.jpg"));
        mascota_repo.save(new Mascota("Nina", "Boxer", 5, 28.3f, "https://pamipe.com/wp-content/uploads/2022/09/Boxer-3.jpg"));
        mascota_repo.save(new Mascota("Bella", "Bulldog Francés", 4, 12.7f, "https://example.com/images/bulldog_frances1.jpg"));
        mascota_repo.save(new Mascota("Milo", "Yorkshire Terrier", 2, 3.0f, "https://example.com/images/yorkshire_terrier1.jpg"));
        mascota_repo.save(new Mascota("Lucy", "Poodle", 3, 8.0f, "https://example.com/images/poodle1.jpg"));
        mascota_repo.save(new Mascota("Duke", "Doberman", 5, 34.0f, "https://example.com/images/doberman2.jpg"));
        mascota_repo.save(new Mascota("Stella", "Cocker Spaniel", 4, 14.0f, "https://cdn.shopify.com/s/files/1/0268/6861/files/perros-cocker-spaniel_grande.jpg?v=1531136757"));
        mascota_repo.save(new Mascota("Bentley", "Bichón Frisé", 3, 7.8f, "https://example.com/images/bichon_frise1.jpg"));
        mascota_repo.save(new Mascota("Toby", "Golden Retriever", 4, 25.0f, "https://example.com/images/golden_retriever4.jpg"));
        mascota_repo.save(new Mascota("Sophie", "Pastor Alemán", 5, 30.0f, "https://example.com/images/pastor_aleman1.jpg"));
        mascota_repo.save(new Mascota("Rocky", "Rottweiler", 4, 45.0f, "https://example.com/images/rottweiler3.jpg"));
        mascota_repo.save(new Mascota("Ruby", "Shih Tzu", 2, 7.5f, "https://example.com/images/shih_tzu1.jpg"));
        mascota_repo.save(new Mascota("Finn", "Beagle", 3, 11.0f, "https://example.com/images/beagle2.jpg"));
        mascota_repo.save(new Mascota("Zoe", "Dachshund", 4, 9.9f, "https://example.com/images/dachshund2.jpg"));
        mascota_repo.save(new Mascota("Riley", "Labrador Retriever", 5, 31.0f, "https://example.com/images/labrador4.jpg"));
        mascota_repo.save(new Mascota("Chloe", "Pomerania", 3, 3.2f, "https://example.com/images/pomerania4.jpg"));
        mascota_repo.save(new Mascota("Bruno", "Boxer", 4, 29.0f, "https://example.com/images/boxer4.jpg"));
        mascota_repo.save(new Mascota("Sadie", "Bulldog Inglés", 5, 25.0f, "https://example.com/images/bulldog_ingles3.jpg"));
        mascota_repo.save(new Mascota("Gus", "Golden Retriever", 4, 26.5f, "https://example.com/images/golden_retriever5.jpg"));
        mascota_repo.save(new Mascota("Molly", "Shih Tzu", 3, 7.4f, "https://example.com/images/shih_tzu2.jpg"));
        mascota_repo.save(new Mascota("Oliver", "Yorkshire Terrier", 2, 3.1f, "https://example.com/images/yorkshire_terrier2.jpg"));
        mascota_repo.save(new Mascota("Buddy", "Beagle", 4, 11.5f, "https://example.com/images/beagle3.jpg"));
        mascota_repo.save(new Mascota("Luna", "Chihuahua", 3, 2.6f, "https://example.com/images/chihuahua3.jpg"));
        mascota_repo.save(new Mascota("Charlie", "Poodle", 5, 8.5f, "https://example.com/images/poodle3.jpg"));
        mascota_repo.save(new Mascota("Max", "Golden Retriever", 6, 27.0f, "https://example.com/images/golden_retriever6.jpg"));
        mascota_repo.save(new Mascota("Bailey", "Labrador Retriever", 4, 30.5f, "https://example.com/images/labrador5.jpg"));
        mascota_repo.save(new Mascota("Roxy", "Boxer", 5, 29.5f, "https://www.creativefabrica.com/wp-content/uploads/2022/09/27/White-Boxer-Dog-With-Nerdy-Glasses-39426639-1-1.png"));
        mascota_repo.save(new Mascota("Nala", "Cocker Spaniel", 3, 15.0f, "https://www.anicura.es/cdn-cgi/image/f=auto,q=60,fit=cover,w=1536,h=1152,g=auto,sharpen=1/AdaptiveImages/powerinit/9309/Print_AniCura_Dogs_224.jpg?stamp=1c447229c9ba11dcdd8da6d2cb96df53e2f8954d"));
        mascota_repo.save(new Mascota("Harley", "Rottweiler", 4, 46.0f, "https://example.com/images/rottweiler4.jpg"));
        mascota_repo.save(new Mascota("Daisy", "Shih Tzu", 2, 7.3f, "https://example.com/images/shih_tzu3.jpg"));
        mascota_repo.save(new Mascota("Cooper", "Yorkshire Terrier", 3, 3.2f, "https://example.com/images/yorkshire_terrier3.jpg"));
        mascota_repo.save(new Mascota("Rosie", "Bulldog Francés", 4, 13.0f, "https://example.com/images/bulldog_frances2.jpg"));
        mascota_repo.save(new Mascota("Bear", "Beagle", 5, 12.0f, "https://example.com/images/beagle4.jpg"));
        mascota_repo.save(new Mascota("Chico", "Pomerania", 2, 3.6f, "https://example.com/images/pomerania5.jpg"));
        mascota_repo.save(new Mascota("Leo", "Golden Retriever", 4, 28.0f, "https://example.com/images/golden_retriever7.jpg"));
        mascota_repo.save(new Mascota("Tucker", "Labrador Retriever", 5, 32.0f, "https://example.com/images/labrador6.jpg"));
        mascota_repo.save(new Mascota("Riley", "Shih Tzu", 3, 7.7f, "https://example.com/images/shih_tzu4.jpg"));
        mascota_repo.save(new Mascota("Penny", "Chihuahua", 2, 2.7f, "https://example.com/images/chihuahua4.jpg"));
        mascota_repo.save(new Mascota("Zoe", "Boxer", 4, 30.0f, "https://soyunperro.com/wp-content/uploads/2019/12/perro-b%C3%B3xer-jugando-en-la-nieve.jpg"));
        mascota_repo.save(new Mascota("Nina", "Rottweiler", 5, 47.0f, "https://example.com/images/rottweiler5.jpg"));
        mascota_repo.save(new Mascota("Maggie", "Poodle", 4, 8.6f, "https://example.com/images/poodle4.jpg"));
        mascota_repo.save(new Mascota("Ellie", "Golden Retriever", 3, 29.5f, "https://example.com/images/golden_retriever8.jpg"));
        mascota_repo.save(new Mascota("Jack", "Beagle", 4, 12.5f, "https://example.com/images/beagle5.jpg"));
        mascota_repo.save(new Mascota("Chester", "Labrador Retriever", 5, 33.0f, "https://example.com/images/labrador7.jpg"));
        mascota_repo.save(new Mascota("Mia", "Pomerania", 2, 3.7f, "https://example.com/images/pomerania6.jpg"));
        mascota_repo.save(new Mascota("Sadie", "Bulldog Francés", 4,     13.3f, "https://example.com/images/bulldog_frances3.jpg"));
        mascota_repo.save(new Mascota("Lola", "Shih Tzu", 3, 7.8f, "https://example.com/images/shih_tzu5.jpg"));
        mascota_repo.save(new Mascota("Sasha", "Yorkshire Terrier", 2, 3.4f, "https://example.com/images/yorkshire_terrier4.jpg"));
        mascota_repo.save(new Mascota("Baxter", "Golden Retriever", 4, 30.0f, "https://example.com/images/golden_retriever9.jpg"));
        mascota_repo.save(new Mascota("Rocky", "Cocker Spaniel", 1, 15.2f, "https://http2.mlstatic.com/D_NQ_NP_647528-MCO46758940301_072021-O.webp"));
        mascota_repo.save(new Mascota("Nina", "Rottweiler", 5, 47.5f, "https://example.com/images/rottweiler6.jpg"));
        mascota_repo.save(new Mascota("Teddy", "Shih Tzu", 4, 7.9f, "https://example.com/images/shih_tzu6.jpg"));
        mascota_repo.save(new Mascota("Oscar", "Labrador Retriever", 5, 34.0f, "https://example.com/images/labrador8.jpg"));

                
        // Asociar mascotas a clientes
        List<Mascota> mascotas = mascota_repo.findAll();
        List<Cliente> clientes = client_repo.findAll();

        int indiceMascota = 0;
        for (Cliente cliente : clientes) {
        for (int i = 0; i < 2 && indiceMascota < mascotas.size(); i++) {
            Mascota mascota = mascotas.get(indiceMascota);
            mascota.setCliente(cliente);
            mascota_repo.save(mascota);
            indiceMascota++;
        }
        }

    }
}