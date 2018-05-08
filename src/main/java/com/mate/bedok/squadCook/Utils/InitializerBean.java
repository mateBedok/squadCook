package com.mate.bedok.squadCook.Utils;

import com.mate.bedok.squadCook.entities.*;
import com.mate.bedok.squadCook.services.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class InitializerBean {

    public InitializerBean(
            UserService us,
            MainFeedPostService mfs,
            CommentService cs,
            SquadService ss,
            RelationshipService rs
    ) {

        User user3 = new User("Laci", "Kiss", "Laca", "laci.kiss@gmail.com", "1992-01-26", "asdasd", "2018-04-05", "/images/hodi_profile.jpg");
        User user4 = new User("Feri", "Nagy", "Ferkó", "feri.nagy@gmail.com", "1992-01-26", "asdasd", "2018-04-05", "/images/norbi_profile.jpg");
        us.saveUser(user3);
        us.saveUser(user4);

        User user1 = new User("Mate", "Bedok", "Maci", "mate.bedok@gmail.com", "1992-01-26", "asdasd", "2018-04-05", "https://scontent-vie1-1.xx.fbcdn.net/v/t1.0-1/p100x100/10400046_1463829200340110_7740717001636395235_n.jpg?_nc_cat=0&oh=8cd981a225ffcfc9568c9308d00006a2&oe=5B6AE5EA");
        MainFeedPost mainFeedPost = new MainFeedPost("Australians each eat 47 kilograms of chicken a year. Surely that's too much, not least because it's sad to see a special occasion meal relegated to cheap protein, eaten unthinkingly in nuggets and wraps, but also because few of those chooks are as delicious as the roasted chicken at Napier Quarter. Like all the meat there, it's carefully sourced and adoringly cooked, as though every bite matters, which it does.", "½ cup plain yogurt\n" +
                "1 tablespoon lemon juice\n" +
                "1 tablespoon onion powder\n" +
                "1 tablespoon minced garlic\n" +
                "1 tablespoon garam masala\n" +
                "1 tablespoon cilantro leaves\n" +
                "1 tablespoon paprika\n" +
                "1 teaspoon coriander\n" +
                "1 teaspoon cumin\n" +
                "½ teaspoon ginger\n" +
                "¼ teaspoon cayenne pepper", "https://zululandobserver.co.za/wp-content/uploads/sites/56/2017/05/fap-09.jpg", "2018-04-07", user3);
        mainFeedPost.setLikeCounter(23);
        User user2 = new User("Dezső", "Varbai", "Dezsi", "dezso@gmail.com", "1992-01-26", "asdasd", "2018-04-05", "https://s3.amazonaws.com/f6s-public/profiles/1383316_original.jpg");
        MainFeedPost mainFeedPost2 = new MainFeedPost("I find nothing unreasonable about paying $4 for Grain Bakery sourdough, $10 for a snacky bowl of lightly spiced polenta fingers, $24 for a light, summery vegetable risotto with lemon ricotta, or $14 for made-to-order crepes suzette. Australians each eat 47 kilograms of chicken a year. Surely that's too much, not least because it's sad to see a special occasion meal relegated to cheap protein, eaten unthinkingly in nuggets and wraps, but also because few of those chooks are as delicious as the roasted chicken at Napier Quarter. Like all the meat there, it's carefully sourced and adoringly cooked, as though every bite matters, which it does.", "1 Tablespoon organic canola or safflower oil or mustard oil or any oil with high smoke point\n" +
                "1 teaspoon cumin seeds\n" +
                "a generous pinch asafetida(hing) optional\n" +
                "1 Tablespoon garlic chopped\n" +
                "2 teaspoons ginger chopped\n" +
                "1 green chili chopped or to taste\n" +
                "1/4 teaspoon turmeric powder\n" +
                "1/2 teaspoon coriander powder or freshly crushed coriander seeds\n" +
                "1/4 teaspoon cumin powder\n" +
                "1/4-1/2 teaspoon chili powder or cayenne\n" +
                "2/3 teaspoon salt or to taste\n" +
                "2 cups cubed potatoes(medium size cubes)\n" +
                "2 overflowing cups of cauliflower florets(large florets broken or cut to a medium size)\n" +
                "1/3-1/2 cup peas", "https://gimmedelicious.com/wp-content/uploads/2016/09/cauliflower-bites-9-of-14.jpg", "2018-04-07", user4);
        mainFeedPost2.setLikeCounter(150);
        MainFeedPost mainFeedPost3 = new MainFeedPost("Think of aloo tikki as delicious Indian potato fritters. These appetizers or snacks are made with mashed potatoes and a variety of spices, formed into patties, then fried in oil. You'll find them sold on the streets of Northern India and on the menu of your local takeout.", "3 large potatoes, peeled, boiled and mashed\n" +
                "3/4 cup frozen peas (uncooked)\n" +
                "1/2 large onion, chopped\n" +
                "1 jalapeno pepper, minced\n" +
                "1 tsp. chili powder\n" +
                "2 tsp. garam masala\n" +
                "1 tsp. cumin powder\n" +
                "1 tbs. grated ginger\n" +
                "1 handful fresh parsley or cilantro leaves, chopped\n" +
                "2 tbs. bread crumbs (I used panko)\n" +
                "4 tbs. flour\n" , "https://thumbs.dreamstime.com/b/indian-food-chicken-dum-biryani-close-up-dish-horizontal-table-110755818.jpg", "2018-04-07", user2);

        Comment comment2 = new Comment("Wow, bro! Lovin' it, gonna try with dem boyzz !!!4", user3  , mainFeedPost3);



        Squad squad = new Squad("Fióklakók", "Crew, posse, gang: an informal group of individuals with a common identity and a sense of solidarity. ", "https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/12/31/15/friends-0.jpg");
        Squad squad2 = new Squad("The Recon Crew", "When worst comes to worst, squad comes first.", "http://i0.kym-cdn.com/entries/icons/mobile/000/014/591/GS5mY6x.jpg");
        Squad squad3 = new Squad("The Wolf Squadron", "We are the Wolf Squadron! Better watch out when you are in the 8th district!", "https://i.pinimg.com/originals/08/ff/ca/08ffcaef9069817768902ab630323958.jpg");
        Squad squad4 = new Squad("The Feral Squad", "Squad means family and family means nobody gets left behind.", "http://i0.kym-cdn.com/photos/images/original/001/166/346/3f2.jpg");
        Squad squad5 = new Squad("The Angels", "I can't really see another squad tryna cross us.", "https://i.pinimg.com/736x/1a/b1/d8/1ab1d89a248c9bc50013a8034813a726--stylish-men-streetstyle.jpg");
        Squad squad6 = new Squad("The White Skulls", "Nobody really likes us, except for us.", "http://i0.kym-cdn.com/photos/images/original/001/166/346/3f2.jpg");
        Squad squad7 = new Squad("Extreme Training Squad", "Homies help homies, always.", "http://i0.kym-cdn.com/photos/images/original/001/166/346/3f2.jpg");
        Squad squad8 = new Squad("Special Rescue Unit", "What a time to be alive.", "http://i0.kym-cdn.com/photos/images/original/001/166/346/3f2.jpg");
        Squad squad9 = new Squad("Specialized Unit", "Started from the bottom now we're here", "http://i0.kym-cdn.com/photos/images/original/001/166/346/3f2.jpg");
        Squad squad10 = new Squad("Emergency Task Crew", "I got a really big team.", "http://i0.kym-cdn.com/photos/images/original/001/166/346/3f2.jpg");
        Squad squad11 = new Squad("The Ghosts", "Right back on my worst behavior.", "http://i0.kym-cdn.com/photos/images/original/001/166/346/3f2.jpg");
        Squad squad12 = new Squad("Special Liberation Unit", "Too glam to give a damn.", "http://i0.kym-cdn.com/photos/images/original/001/166/346/3f2.jpg");
        Squad squad13 = new Squad("The Turtles", "Always better together xXx.", "http://i0.kym-cdn.com/photos/images/original/001/166/346/3f2.jpg");


        Set<Squad> squads = new HashSet<>();
        squads.add(squad);

        Set<Squad> user2squads = new HashSet<>();
        user2squads.add(squad2);
        user2squads.add(squad3);
        user2squads.add(squad4);
        user2squads.add(squad5);
        user2squads.add(squad6);
        user2squads.add(squad7);


        user1.setSquads(squads);

        ss.saveSquad(squad);
        ss.saveSquad(squad2);
        ss.saveSquad(squad3);
        ss.saveSquad(squad4);
        ss.saveSquad(squad5);
        ss.saveSquad(squad6);
        ss.saveSquad(squad7);
        ss.saveSquad(squad8);
        ss.saveSquad(squad9);
        ss.saveSquad(squad10);
        ss.saveSquad(squad11);
        ss.saveSquad(squad12);
        ss.saveSquad(squad13);



        us.saveUser(user1);
        us.saveUser(user2);

        mfs.saveMainFeedPost(mainFeedPost2);

        mfs.saveMainFeedPost(mainFeedPost3);
        mfs.saveMainFeedPost(mainFeedPost);
        cs.initSave(comment2);

        //relationship



        Relationship relationship1 = new Relationship(user1, squad);
        relationship1.setStatus(RelationshipStatusEnum.ACCEPTED);
        Relationship relationship2 = new Relationship(user1, squad2);
        Relationship relationship3 = new Relationship(user2, squad);

        rs.save(relationship1);
        rs.save(relationship2);
        rs.save(relationship3);

        //https://prezi.com/p/1m1g5zy2s9f4/
    }
}
