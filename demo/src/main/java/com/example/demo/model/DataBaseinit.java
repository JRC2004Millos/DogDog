package com.example.demo.model;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ConsultaRepository;
import com.example.demo.repository.DrogaRepository;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.VeterinarioRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DataBaseinit implements ApplicationRunner {

        @Autowired
        ClienteRepository client_repo;

        @Autowired
        MascotaRepository mascota_repo;

        @Autowired
        VeterinarioRepository vet_repo;

        @Autowired
        DrogaRepository droga_repo;

        @Autowired
        ConsultaRepository consulta_repo;

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
                client_repo.save(new Cliente(963741, "Ricky Martin", "ricky.martin@gmail.com", 852963));
                client_repo.save(new Cliente(753159, "Thalía", "thalia@gmail.com", 951357));
                client_repo.save(new Cliente(6547891, "Enrique Iglesias", "enrique.iglesias@gmail.com", 159753));
                client_repo.save(new Cliente(7412581, "Carlos Vives", "vives.carlos@gmail.com", 852963));
                client_repo.save(new Cliente(8529631, "Juanes", "juanes@gmail.com", 753159));
                client_repo.save(new Cliente(9513571, "Alejandro Sanz", "sanz.alejandro@gmail.com", 654852));
                client_repo.save(new Cliente(1597531, "Pablo Alborán", "pablo.alboran@gmail.com", 321654));
                client_repo.save(new Cliente(2589631, "Manuel Turizo", "turizo.manuel@gmail.com", 654789));
                client_repo.save(new Cliente(456741, "Kany García", "kany.garcia@gmail.com", 852963));
                client_repo.save(new Cliente(123789, "Gloria Trevi", "gloria.trevi@gmail.com", 159753));
                client_repo.save(new Cliente(9874561, "David Bisbal", "david.bisbal@gmail.com", 753951));
                client_repo.save(new Cliente(6549631, "Alejandra Guzmán", "alejandra.guzman@gmail.com", 369852));
                client_repo.save(new Cliente(9517531, "Ricardo Arjona", "arjona@gmail.com", 963852));
                client_repo.save(new Cliente(9638521, "Amanda Miguel", "amanda.miguel@gmail.com", 456741));
                client_repo.save(new Cliente(3692581, "Eros Ramazzotti", "eros.ramazzotti@gmail.com", 654852));
                client_repo.save(new Cliente(123123, "Selena Gomez", "selena.gomez@gmail.com", 789123));
                client_repo.save(new Cliente(321321, "Justin Bieber", "justin.bieber@gmail.com", 654789));
                client_repo.save(new Cliente(987987, "Ariana Grande", "ariana.grande@gmail.com", 852963));
                client_repo.save(new Cliente(654654, "Taylor Swift", "taylor.swift@gmail.com", 963741));
                client_repo.save(new Cliente(789789, "Shawn Mendes", "shawn.mendes@gmail.com", 159753));
                client_repo.save(new Cliente(852852, "Billie Eilish", "billie.eilish@gmail.com", 258963));
                client_repo.save(new Cliente(963963, "Dua Lipa", "dua.lipa@gmail.com", 369852));
                client_repo.save(new Cliente(6543211, "João Gilberto", "joao.gilberto@gmail.com", 852741));
                client_repo.save(new Cliente(7891231, "Zara Larsson", "zara.larsson@gmail.com", 654321));
                client_repo.save(new Cliente(8529630, "Aitana", "aitana@gmail.com", 123456));
                client_repo.save(new Cliente(9632581, "Lali", "lali@gmail.com", 987654));

                mascota_repo.save(new Mascota("Luna", "Beagle", 3, 10.5f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/1200px-Shemsu_Sotis_Perun.jpg",
                                "Dermatitis"));
                mascota_repo.save(new Mascota("Max", "Golden Retriever", 5, 25.3f,
                                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09golden20retriever.jpg?itok=48StbVfe",
                                "Displasia de cadera"));
                mascota_repo.save(new Mascota("Bella", "Bulldog Francés", 4, 12.7f,
                                "https://picartpetcare.com/wp-content/uploads/2020/05/BULLDOG-FRANC%C3%89S.jpg",
                                "Infección respiratoria"));
                mascota_repo.save(new Mascota("Charlie", "Labrador Retriever", 1, 30.2f,
                                "https://pamipe.com/wiki/wp-content/uploads/2022/09/Labrador-Retriever.jpg",
                                "Oído externo inflamado"));
                mascota_repo.save(new Mascota("Lucy", "Poodle", 2, 8.4f,
                                "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQbIyCu-ZrIJlcLWxk9iYlL1ighFx-itgPbzp-VTG3Hma1EVy44",
                                "Alergia alimentaria"));
                mascota_repo.save(new Mascota("Rocky", "Boxer", 5, 28.9f,
                                "https://cdn.royalcanin-weshare-online.io/ZT-S7XoBRYZmsWpc4beN/v9/bp-lot-2-boxer-bw-ws-2",
                                "Cardiomiopatía"));
                mascota_repo.save(new Mascota("Daisy", "Cocker Spaniel", 3, 14.1f,
                                "https://blog-static.petlove.com.br/wp-content/uploads/2018/06/cocker-figado-tan.jpg",
                                "Otitis"));
                mascota_repo.save(new Mascota("Cooper", "Border Collie", 4, 20.0f,
                                "https://perronalidad.com.co/wp-content/uploads/2022/07/COMO-SE-COMPORTA-UN-BORDER-COLIE.jpg", "Epilepsia"));
                mascota_repo.save(new Mascota("Molly", "Chihuahua", 3, 2.5f,
                                "https://example.com/images/chihuahua1.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Buddy", "Siberian Husky", 4, 22.8f,
                                "https://example.com/images/siberian_husky1.jpg", "Alergia a la comida"));
                mascota_repo.save(new Mascota("Zoe", "Dachshund", 5, 9.8f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRa3ewvi6qjaUE5Z87OXoKlxqHu83Tc8u5bnA&s",
                                "Problemas de columna"));
                mascota_repo.save(new Mascota("Bailey", "Shih Tzu", 2, 7.4f,
                                "https://www.perro-obediente.com/blog/wp-content/uploads/2023/04/cachorro-shih-tzu-aislado-blanco_87557-18423.jpg",
                                "Conjuntivitis"));
                mascota_repo.save(new Mascota("Oliver", "Pomerania", 3, 3.2f,
                                "https://example.com/images/pomerania1.jpg", "Enfermedad periodontal"));
                mascota_repo.save(new Mascota("Sadie", "Bulldog Inglés", 6, 24.5f,
                                "https://lucasylola.es/blog/wp-content/uploads/2019/04/bulldog-1.jpg", "Dificultad para respirar"));
                mascota_repo.save(new Mascota("Toby", "Bichón Frisé", 5, 7.9f,
                                "https://blog.mascotaysalud.com/wp-content/uploads/2020/03/Bich%C3%B3n-Fris%C3%A9-rostro.jpg",
                                "Alergia cutánea"));
                mascota_repo.save(new Mascota("Sophie", "Pastor Alemán", 6, 28.7f,
                                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTlgTALLDZ01S1_A_EvwHtZKvIk9lUcBXZrdiB1RFqLZogklYVE",
                                "Problemas en las articulaciones"));
                mascota_repo.save(new Mascota("Bear", "Rottweiler", 4, 45.2f,
                                "https://example.com/images/rottweiler1.jpg", "Displasia de cadera"));
                mascota_repo.save(new Mascota("Maggie", "Yorkshire Terrier", 3, 3.1f,
                                "https://media.graphassets.com/output=format:webp/KHpTY4nvQMiNxkgNcfNm",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Jack", "Pug", 5, 8.9f, "https://example.com/images/pug1.jpg",
                                "Ojos secos"));
                mascota_repo.save(new Mascota("Chloe", "Caniche", 4, 4.8f, "https://example.com/images/caniche1.jpg",
                                "Dermatitis alérgica"));
                mascota_repo.save(new Mascota("Duke", "Doberman", 5, 34.6f, "https://example.com/images/doberman1.jpg",
                                "Problemas cardíacos"));
                mascota_repo.save(new Mascota("Roxy", "Akita", 4, 32.7f, "https://example.com/images/akita1.jpg",
                                "Infección en la piel"));
                mascota_repo.save(new Mascota("Ruby", "Samoyedo", 4, 21.4f, "https://example.com/images/samoyedo1.jpg",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Oscar", "Mastín", 5, 50.3f, "https://example.com/images/mastin1.jpg",
                                "Displasia de cadera"));
                mascota_repo.save(new Mascota("Milo", "Pug", 3, 8.7f, "https://example.com/images/pug2.jpg",
                                "Problemas de piel"));
                mascota_repo.save(new Mascota("Rosie", "Chihuahua", 2, 2.3f,
                                "https://example.com/images/chihuahua2.jpg", "Cataratas"));
                mascota_repo.save(new Mascota("Lily", "Shih Tzu", 3, 7.2f,
                                "https://static.wixstatic.com/media/aa8751_1aa95fd67b9e4f13850e5de823d7fb5c~mv2.jpg/v1/fill/w_736,h_1000,al_c,q_85,enc_auto/aa8751_1aa95fd67b9e4f13850e5de823d7fb5c~mv2.jpg",
                                "Problemas en los ojos"));
                mascota_repo.save(new Mascota("Gus", "Beagle", 4, 11.0f,
                                "https://www.elmueble.com/medio/2023/03/02/perro-de-raza-beagle_67c65dda_230302133829_900x900.jpg",
                                "Infección en el oído"));
                mascota_repo.save(new Mascota("Bruno", "Labrador Retriever", 5, 30.8f,
                                "https://www.vidavetcare.com/wp-content/uploads/sites/234/2022/04/labrador-retriever-dog-breed-info.jpeg", "Displasia de cadera"));
                mascota_repo.save(new Mascota("Ellie", "Cocker Spaniel", 3, 14.5f,
                                "https://tierarzt-karlsruhe-durlach.de/storage/2024/04/Cocker-Spaniel-Krankheiten.webp",
                                "Infección ocular"));
                mascota_repo.save(new Mascota("Finn", "Border Collie", 4, 20.4f,
                                "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/no-lo-dejes-al-azar-border-collie.jpg", "Alergias"));
                mascota_repo.save(new Mascota("Purina", "Boxer", 1, 27.9f,
                                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-07Boxer1.jpg?itok=Y2i45vCP",
                                "Problemas en el corazón"));
                mascota_repo.save(new Mascota("Louie", "Pomerania", 2, 3.4f,
                                "https://example.com/images/pomerania2.jpg", "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Mia", "Yorkshire Terrier", 4, 3.6f,
                                "https://example.com/images/yorkshire_terrier1.jpg", "Cataratas"));
                mascota_repo.save(new Mascota("Bear", "Golden Retriever", 6, 32.5f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmI7Mdzsj_yuC0JLzVf6XEtK5A0yOKM9xGUg&s",
                                "Problemas en las articulaciones"));
                mascota_repo.save(new Mascota("Lucy", "Chihuahua", 3, 2.2f, "https://example.com/images/chihuahua3.jpg",
                                "Problemas dentales"));
                mascota_repo.save(new Mascota("Kaiser", "Pastor Alemán", 3, 6.5f, "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/razas-de-perros-pastor-aleman-570x455-1.jpg",
                                "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Rocky", "Beagle", 4, 10.8f,
                                "https://www.animalbehaviorcollege.com/wp-content/uploads/2015/03/beagle.jpg",
                                "Problemas en la piel"));
                mascota_repo.save(new Mascota("Sophie", "Dachshund", 5, 9.1f,
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRm_lSuPfR0FIkU8bP7W7O97pylK6Wyupzq8K-TpYw&iTHyPvCEyw&usqp=CAU",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Charlie", "Boxer", 4, 27.5f, "https://www.ecured.cu/images/thumb/1/1b/Boxer.jpg/260px-Boxer.jpg",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Maggie", "Shih Tzu", 3, 8.2f, "https://www.parashihtzu.top/wp-content/uploads/2022/09/dog-gf1fb5789d_1280.jpg",
                                "Infección en la piel"));
                mascota_repo.save(new Mascota("Rosie", "Dachshund", 5, 10.2f,
                                "https://example.com/images/dachshund2.jpg", "Problemas digestivos"));
                mascota_repo.save(new Mascota("Roxy", "Cocker Spaniel", 4, 15.4f,
                                "https://www.hundeo.com/wp-content/uploads/2019/09/Amerikanischer-Cocker-Spaniel-seitlich.jpg", "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Lily", "Shih Tzu", 1, 6.0f, "https://i.pinimg.com/originals/4f/ce/9c/4fce9c38b6ee07b2831c7df2a83ecf14.jpg",
                                "Infección ocular"));
                mascota_repo.save(new Mascota("Finn", "Yorkshire Terrier", 5, 4.2f,
                                "https://example.com/images/yorkshire_terrier2.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Bella", "Siberian Husky", 6, 25.6f,
                                "https://example.com/images/siberian_husky2.jpg", "Problemas en las articulaciones"));
                mascota_repo.save(new Mascota("Buddy", "Beagle", 2, 9.5f, "https://www.zooplus.es/magazine/wp-content/uploads/2023/12/Beagle-harrier.jpg",
                                "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Jack", "Pastor Alemán", 1, 4.2f, "https://www.tiendanimal.es/articulos/wp-content/uploads/2017/11/Como-educar-y-entrenar-a-un-pastor-aleman.jpg",
                                "Problemas articulares"));
                mascota_repo.save(new Mascota("Nala", "Shih Tzu", 12, 7.5f, "https://www.hundeo.com/wp-content/uploads/2019/01/Shih-Tzu-1.jpg",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Rosie", "Poodle", 3, 6.8f, "https://cdn.shopify.com/s/files/1/0268/6861/files/2771407690_36c542893e_b_480x480.jpg?v=1684857441",
                                "Alergia a la comida"));
                mascota_repo.save(new Mascota("Oscar", "Yorkshire Terrier", 5, 3.0f,
                                "https://example.com/images/yorkshire_terrier3.jpg", "Infección en la piel"));
                mascota_repo.save(new Mascota("Marinet", "Cocker Spaniel", 6, 15.2f,
                                "https://images.ctfassets.net/550nf1gumh01/4AocMzBpp93n9pmqzTepjo/e2159f5c418a774d4975c6716269eb3d/iStock-513937472.jpg?q=90&w=1240", "Problemas en los ojos"));
                mascota_repo.save(new Mascota("Mia", "Beagle", 3, 10.9f, "https://images.ctfassets.net/550nf1gumh01/6zwLKAfltciBljUmEdYP3n/21191083f31cb0a43647cddbf29de913/iStock-1411469044.jpg?q=90&w=1240",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Dante", "Boxer", 9, 29.3f, "https://www.publicdomainpictures.net/pictures/40000/nahled/boxer-dog.jpg",
                                "Enfermedad cardíaca"));
                mascota_repo.save(new Mascota("Toby", "Dachshund", 3, 9.5f, "https://example.com/images/dachshund3.jpg",
                                "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Rosie", "Shih Tzu", 4, 8.2f, "https://img.freepik.com/foto-gratis/perro-shih-tzu-relajandose-sofa-sala-estar_637285-4652.jpg",
                                "Problemas de piel"));
                mascota_repo.save(new Mascota("Finn", "Pomerania", 2, 3.6f, "https://example.com/images/pomerania5.jpg",
                                "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Lily", "Siberian Husky", 6, 24.8f,
                                "https://example.com/images/siberian_husky3.jpg", "Problemas articulares"));
                mascota_repo.save(new Mascota("Bella", "Labrador Retriever", 5, 33.2f,
                                "https://static.a-alvarez.com/img/ybc_blog/post/labrador-retriever.jpg", "Problemas en la piel"));
                mascota_repo.save(new Mascota("Zoe", "Golden Retriever", 4, 30.5f,
                                "https://gosbi.com/wp-content/uploads/2023/06/stephen-andrews-lEe3-hTg4Vg-unsplash-1080x675.jpg", "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Maggie", "Border Collie", 3, 18.0f,
                                "https://www.wasky.es/wp-content/uploads/pexels-alois-moubax-3523317-scaled.jpg", "Problemas en los ojos"));
                mascota_repo.save(new Mascota("Sof", "Poodle", 4, 6.5f, "https://cdn.royalcanin-weshare-online.io/rj-393oBRYZmsWpc6bf3/v5/bp-lot-1-poodle-couleur-portrait",
                                "Alergia alimentaria"));
                mascota_repo.save(new Mascota("Oscar", "Beagle", 14, 11.5f, "https://thumbs.dreamstime.com/b/un-perro-viejo-del-beagle-16953148.jpg",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Buddy", "Siberian Husky", 4, 22.0f,
                                "https://example.com/images/siberian_husky4.jpg", "Alergia a la comida"));
                mascota_repo.save(new Mascota("Roxy", "Pug", 3, 7.8f, "https://example.com/images/pug4.jpg",
                                "Problemas de piel"));
                mascota_repo.save(new Mascota("Nala", "Dachshund", 4, 9.0f, "https://example.com/images/dachshund4.jpg",
                                "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Rosie", "Cocker Spaniel", 9, 16.0f,
                                "https://i0.wp.com/www.kennelclubargentino.org.ar/storage/2020/04/cocker-spaniel-con-hoja-en-la-boca.jpg", "Problemas de piel"));
                mascota_repo.save(new Mascota("Gus", "Shih Tzu", 5, 7.7f, "https://cdn.pixabay.com/photo/2022/05/02/20/43/shih-tzu-7170411_640.jpg",
                                "Problemas dentales"));
                mascota_repo.save(new Mascota("Lily", "Pomerania", 3, 3.0f, "https://example.com/images/pomerania6.jpg",
                                "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Rosie", "Border Collie", 4, 21.5f,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Blue_Merle_Border_Collie._Female.jpg/1200px-Blue_Merle_Border_Collie._Female.jpg", "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Oscar", "Pug", 5, 9.0f, "https://example.com/images/pug5.jpg",
                                "Enfermedad cardíaca"));
                mascota_repo.save(new Mascota("Roxy", "Pomerania", 3, 3.2f, "https://example.com/images/pomerania7.jpg",
                                "Problemas articulares"));
                mascota_repo.save(new Mascota("Maggie", "Siberian Husky", 6, 26.0f,
                                "https://example.com/images/siberian_husky5.jpg", "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Mia", "Yorkshire Terrier", 2, 3.4f,
                                "https://example.com/images/yorkshire_terrier4.jpg", "Enfermedad de piel"));
                mascota_repo.save(new Mascota("Toby", "Labrador Retriever", 5, 32.0f,
                                "https://traindee.com/wp-content/uploads/labrador-retriever-black-dog-breed-1-400x400.jpg", "Problemas articulares"));
                mascota_repo.save(new Mascota("Finn", "Shih Tzu", 2, 7.8f, "https://cdn.britannica.com/05/234205-050-F8D2E018/Shih-tzu-dog.jpg",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Sophie", "Pomerania", 2, 3.6f,
                                "https://example.com/images/pomerania8.jpg", "Alergias respiratorias"));
                mascota_repo.save(new Mascota("Rosie", "Golden Retriever", 4, 31.5f,
                                "https://www.animalfiel.com/wp-content/uploads/2022/12/precio-de-un-golden-retriever.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Gus", "Pug", 5, 8.4f, "https://example.com/images/pug6.jpg",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Buddy", "Shih Tzu", 3, 6.9f, "https://images2-mega.cdn.mdstrm.com/meganoticias/2024/05/14/_447481_3_66436a3a4a882.jpg",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Bella", "Cocker Spaniel", 3, 14.0f,
                                "https://wawapedia.wawasfood.com/wp-content/uploads/2022/11/46.-Cocker-Spaniel.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Max", "Labrador Retriever", 1, 29.4f,
                                "https://www.rover.com/blog/wp-content/uploads/2018/11/lab1.jpg", "Infección en la piel"));
                mascota_repo.save(new Mascota("Genya", "Beagle", 12, 11.3f, "https://t1.ea.ltmcdn.com/es/posts/2/0/2/enfermedades_metabolicas_23202_7_600.jpg",
                                "Problemas articulares"));
                mascota_repo.save(new Mascota("Nala", "Pug", 5, 7.9f, "https://example.com/images/pug7.jpg",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Cesar", "Golden Retriever", 6, 30.0f,
                                "https://static.wixstatic.com/media/34e812_826572739aa14ecaa00291399634f9f1~mv2.jpg/v1/fill/w_1000,h_1000,al_c,q_85,usm_0.66_1.00_0.01/34e812_826572739aa14ecaa00291399634f9f1~mv2.jpg", "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Marco", "Shih Tzu", 6, 7.1f, "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/U3XHVG4MXFGPLC4PKBO7NZUV6E.jpg",
                                "Enfermedad de piel"));
                mascota_repo.save(new Mascota("Roxy", "Beagle", 3, 10.9f, "https://img-rpba.s3.ap-southeast-2.amazonaws.com/wp-content/uploads/2023/01/27135918/beagle.jpeg",
                                "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Sophie", "Pomerania", 4, 3.5f,
                                "https://example.com/images/pomerania9.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Finn", "Siberian Husky", 6, 26.5f,
                                "https://example.com/images/siberian_husky6.jpg", "Alergias respiratorias"));
                mascota_repo.save(new Mascota("Mia", "Labrador Retriever", 4, 33.0f,
                                "https://www.purina.es/sites/default/files/styles/ttt_image_510/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09labrador20retriever.jpg?itok=VVWHGD7o", "Problemas dentales"));
                mascota_repo.save(new Mascota("Toby", "Pug", 3, 7.6f, "https://example.com/images/pug8.jpg",
                                "Infección ocular"));
                mascota_repo.save(new Mascota("Rosie", "Pomerania", 2, 3.7f,
                                "https://example.com/images/pomerania10.jpg", "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Gus", "Beagle", 7, 11.1f, "https://media-be.chewy.com/wp-content/uploads/2021/04/24140608/GettyImages-1714338737-923x615.jpg",
                                "Problemas digestivos"));
                mascota_repo.save(new Mascota("Sophie", "Golden Retriever", 10, 32.5f,
                                "https://www.terranea.es/assets/images/razas/golden_retriever2.jpg", "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Maximiliano", "Boxer", 4, 27.8f, "https://www.aon.es/personales/seguro-perro-gato/wp-content/uploads/sites/2/2021/05/perro-boxer.jpg",
                                "Problemas en los ojos"));
                mascota_repo.save(new Mascota("Maggie", "Dachshund", 3, 9.7f,
                                "https://example.com/images/dachshund5.jpg", "Infección en la piel"));
                mascota_repo.save(new Mascota("Rosie", "Poodle", 6, 6.2f, "https://thumbs.dreamstime.com/b/caniche-est%C3%A1ndar-albaricoque-33442566.jpg",
                                "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Oscar", "Siberian Husky", 5, 25.0f,
                                "https://example.com/images/siberian_husky7.jpg", "Problemas articulares"));
                mascota_repo.save(new Mascota("Maca", "Golden Retriever", 9, 31.7f,
                                "https://heronscrossing.vet/wp-content/uploads/Golden-Retriever.jpg", "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Toby", "Pug", 3, 7.2f, "https://example.com/images/pug9.jpg",
                                "Problemas en los ojos"));
                mascota_repo.save(new Mascota("Harley", "Shih Tzu", 8, 7.4f, "https://i0.wp.com/mascooriente.co/wp-content/uploads/2020/02/mascooriente_shih-tzu.jpg?fit=520%2C355&ssl=1",
                                "Enfermedad de piel"));
                mascota_repo.save(new Mascota("Mia", "Yorkshire Terrier", 2, 3.5f,
                                "https://example.com/images/yorkshire_terrier6.jpg", "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Daisy", "Labrador Retriever", 1, 31.2f,
                                "https://canbotey.com/wp-content/uploads/2022/06/cachorro-labrador-amarillo-sentado.webp", "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Rosie", "Pomerania", 5, 3.8f,
                                "https://example.com/images/pomerania11.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Oscar", "Siberian Husky", 4, 24.0f,
                                "https://example.com/images/siberian_husky8.jpg", "Alergias respiratorias"));
                mascota_repo.save(new Mascota("Maggie", "Dachshund", 6, 9.2f,
                                "https://example.com/images/dachshund6.jpg", "Problemas digestivos"));
                mascota_repo.save(new Mascota("Narnia", "Beagle", 4, 11.2f, "https://www.richardancheta.com/cart/htdocs/big/dog/Beagle.gif",
                                "Problemas en los ojos"));
                mascota_repo.save(new Mascota("Atenea", "Poodle", 2, 6.1f, "https://i.pinimg.com/474x/1c/86/ff/1c86ffbd30f51d97751652e78aeca91d.jpg",
                                "Enfermedad de piel"));
                mascota_repo.save(new Mascota("Rosie", "Pug", 3, 7.3f, "https://example.com/images/pug10.jpg",
                                "Problemas respiratorios"));
                mascota_repo.save(new Mascota("Gus", "Cocker Spaniel", 4, 14.0f,
                                "https://content.speakup.es/medio/2024/06/09/english-cocker-spaniel_d9fc20fe_240609114930_1280x720.jpg", "Problemas dentales"));
                mascota_repo.save(new Mascota("Stain", "Labrador Retriever", 5, 33.1f,
                                "https://www.perrolabrador.net/wp-content/uploads/2015/12/labrador_chocolate.jpg", "Problemas articulares"));
                mascota_repo.save(new Mascota("Finn", "Yorkshire Terrier", 2, 3.8f,
                                "https://example.com/images/yorkshire_terrier7.jpg", "Enfermedad respiratoria"));
                mascota_repo.save(new Mascota("Maggie", "Pomerania", 4, 3.7f,
                                "https://example.com/images/pomerania12.jpg", "Alergias cutáneas"));
                mascota_repo.save(new Mascota("Rosie", "Shih Tzu", 1, 6.7f, "https://www.parashihtzu.top/wp-content/uploads/2020/08/20200813_210700_0000-801x1024.png",
                                "Problemas respiratorios"));

                vet_repo.save(new Veterinario("Dr. Juan Pérez", 111111, "clave123", "Cirugía",
                                "https://universidadeuropea.com/resources/media/images/medicina-veterinaria-800x450.width-1200.format-webp.webp",
                                150));
                vet_repo.save(new Veterinario("Dra. Ana Gómez", 222222, "clave234", "Medicina Interna",
                                "https://www.infobae.com/new-resizer/ZnDkR1HUD3VOYyxcl1NfySwaToc=/1440x960/filters:format(webp):quality(85)/cloudfront-us-east-1.images.arcpublishing.com/infobae/L6GI2ZSXFZGADESR57UO666ZE4.jpg",
                                200));
                vet_repo.save(new Veterinario("Dr. Carlos López", 333333, "clave345", "Dermatología",
                                "https://blog.agrovetmarket.com/wp-content/uploads/2020/05/vet.jpg", 180));
                vet_repo.save(new Veterinario("Dra. Laura Martínez", 444444, "clave456", "Odontología",
                                "https://bensvet.com.br/wp-content/uploads/2020/03/blog-5-passos-para-se-tornar-o-melhor-m%C3%A9dico-veterin%C3%A1rio.jpg",
                                210));
                vet_repo.save(new Veterinario("Dr. Andrés Fernández", 555555, "clave567", "Cardiología",
                                "https://media.diariolasamericas.com/p/dd615822f3890b61f37609e2635dd657/adjuntos/216/imagenes/100/128/0100128714/1200x630/smart/dia-mundial-del-veterinariojpg.jpg",
                                170));
                vet_repo.save(new Veterinario("Dra. Patricia Ruiz", 666666, "clave678", "Neurología",
                                "https://blog.comparasoftware.com/wp-content/uploads/2022/02/software-veterinario-768x480.jpg",
                                160));
                vet_repo.save(new Veterinario("Dr. Javier Morales", 777777, "clave789", "Oftalmología",
                                "https://plus.unsplash.com/premium_photo-1677165483776-3e2e85595746?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8dmV0ZXJpbmFyaWF8ZW58MHx8MHx8fDA%3D",
                                190));
                vet_repo.save(new Veterinario("Dra. Beatriz García", 888888, "clave890", "Oncología",
                                "https://blog.uchceu.es/veterinaria/wp-content/uploads/sites/12/2012/07/293887-500x480.jpg",
                                230));
                vet_repo.save(new Veterinario("Dr. Mario Torres", 999999, "clave901", "Gastroenterología",
                                "https://www.veterinariaelbosque.cl/images/noti_petcovid_3.jpg", 140));
                vet_repo.save(new Veterinario("Dra. Claudia Sánchez", 101010, "clave1234", "Pediatría",
                                "https://bogota.gov.co/sites/default/files/styles/1050px/public/2024-05/vertinario-1.jpg",
                                220));

                droga_repo.save(new Droga("Ibuprofeno", "Anti-inflamatorio utilizado para tratar el dolor."));
                droga_repo.save(new Droga("Paracetamol", "Analgésico y antipirético utilizado para tratar la fiebre."));
                droga_repo.save(new Droga("Amoxicilina", "Antibiótico utilizado para tratar infecciones bacterianas."));
                droga_repo.save(new Droga("Aspirina", "Analgésico utilizado para aliviar dolores y reducir la fiebre."));
                droga_repo.save(new Droga("Ciprofloxacino", "Antibiótico utilizado para tratar infecciones graves."));
                droga_repo.save(new Droga("Metformina", "Medicamento utilizado para controlar los niveles de azúcar en sangre."));
                droga_repo.save(new Droga("Furosemida", "Diurético utilizado para tratar la retención de líquidos."));
                droga_repo.save(new Droga("Clorfenamina", "Antihistamínico utilizado para aliviar alergias."));
                droga_repo.save(new Droga("Diazepam", "Ansiolítico utilizado para tratar la ansiedad y los espasmos musculares."));
                droga_repo.save(new Droga("Omeprazol", "Inhibidor de ácido utilizado para tratar el reflujo ácido y las úlceras."));
                droga_repo.save(new Droga("Hidrocortisona", "Corticosteroide utilizado para tratar la inflamación y alergias."));
                droga_repo.save(new Droga("Lidocaína", "Anestésico local utilizado para aliviar el dolor."));
                droga_repo.save(new Droga("Diclofenaco", "Analgésico y antiinflamatorio utilizado para el dolor y la inflamación."));
                droga_repo.save(new Droga("Tramadol", "Analgésico opioide utilizado para tratar el dolor moderado a severo."));
                droga_repo.save(new Droga("Cefalexina", "Antibiótico utilizado para tratar infecciones bacterianas."));
                droga_repo.save(new Droga("Salbutamol", "Broncodilatador utilizado para el tratamiento del asma."));
                droga_repo.save(new Droga("Metoclopramida", "Medicamento utilizado para tratar el reflujo gastroesofágico y náuseas."));
                droga_repo.save(new Droga("Naproxeno", "Analgésico y antiinflamatorio utilizado para tratar el dolor y la inflamación."));
                droga_repo.save(new Droga("Ketorolaco", "Analgésico utilizado para el tratamiento del dolor agudo."));
                droga_repo.save(new Droga("Captopril", "Inhibidor de la ECA utilizado para tratar la hipertensión arterial."));
                droga_repo.save(new Droga("Enalapril", "Medicamento utilizado para tratar la hipertensión y la insuficiencia cardíaca."));
                droga_repo.save(new Droga("Fentanilo", "Analgésico opioide utilizado para tratar el dolor severo."));
                droga_repo.save(new Droga("Prednisona", "Corticosteroide utilizado para tratar enfermedades inflamatorias."));
                droga_repo.save(new Droga("Dexametasona", "Corticosteroide utilizado para tratar la inflamación y las enfermedades autoinmunes."));
                droga_repo.save(new Droga("Ranitidina", "Medicamento utilizado para reducir el ácido estomacal."));
                droga_repo.save(new Droga("Alprazolam", "Ansiolítico utilizado para tratar la ansiedad y los trastornos del pánico."));
                droga_repo.save(new Droga("Clindamicina", "Antibiótico utilizado para tratar infecciones bacterianas."));
                droga_repo.save(new Droga("Levotiroxina", "Medicamento utilizado para tratar el hipotiroidismo."));
                droga_repo.save(new Droga("Tamsulosina", "Medicamento utilizado para mejorar la micción en hombres con agrandamiento de la próstata."));
                droga_repo.save(new Droga("Warfarina", "Anticoagulante utilizado para prevenir la formación de coágulos de sangre."));
                
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

                Calendar calendar = Calendar.getInstance();

                calendar.set(2023, Calendar.MAY, 10);
                consulta_repo.save(new Consulta(calendar.getTime()));
                
                calendar.set(2023, Calendar.JUNE, 15);
                consulta_repo.save(new Consulta(calendar.getTime()));
                
                calendar.set(2023, Calendar.JULY, 20);
                consulta_repo.save(new Consulta(calendar.getTime()));
                
                calendar.set(2023, Calendar.AUGUST, 25);
                consulta_repo.save(new Consulta(calendar.getTime()));
                
                calendar.set(2023, Calendar.SEPTEMBER, 30);
                consulta_repo.save(new Consulta(calendar.getTime()));
                
                calendar.set(2023, Calendar.OCTOBER, 5);
                consulta_repo.save(new Consulta(calendar.getTime()));
                
                calendar.set(2023, Calendar.NOVEMBER, 10);
                consulta_repo.save(new Consulta(calendar.getTime()));
                
                calendar.set(2023, Calendar.DECEMBER, 15);
                consulta_repo.save(new Consulta(calendar.getTime()));
                
                calendar.set(2024, Calendar.JANUARY, 20);
                consulta_repo.save(new Consulta(calendar.getTime()));
                
                calendar.set(2024, Calendar.FEBRUARY, 25);
                consulta_repo.save(new Consulta(calendar.getTime()));                

                int cantidad_mascota = mascota_repo.findAll().size();
                int cantidad_vet = vet_repo.findAll().size();
                int cantidad_droga = droga_repo.findAll().size();

                for (Consulta consulta: consulta_repo.findAll()){
                        int mascota_id = ThreadLocalRandom.current().nextInt(1, cantidad_mascota);
                        int vet_id = ThreadLocalRandom.current().nextInt(1, cantidad_vet);
                        int droga_id = ThreadLocalRandom.current().nextInt(1, cantidad_droga);

                        Mascota mascota = mascota_repo.findById(Long.valueOf(mascota_id)).get(); 
                        Veterinario veterinario = vet_repo.findById(Long.valueOf(vet_id)).get();
                        Droga droga = droga_repo.findById(Long.valueOf(droga_id)).get();

                        consulta.setMascota(mascota);
                        consulta.setVeterinario(veterinario);
                        consulta.setDroga(droga);
                }
        }
}