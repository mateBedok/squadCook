package com.mate.bedok.squadCook.Utils;

import com.mate.bedok.squadCook.entities.Comment;
import com.mate.bedok.squadCook.entities.MainFeedPost;
import com.mate.bedok.squadCook.entities.User;
import com.mate.bedok.squadCook.services.CommentService;
import com.mate.bedok.squadCook.services.MainFeedPostService;
import com.mate.bedok.squadCook.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(UserService us, MainFeedPostService mfs, CommentService cs) {

        User user1 = new User("Mate", "Bedok", "Maci", "mate.bedok@gmail.com", "1992-01-26", "asdasd", "2018-04-05", "https://scontent-vie1-1.xx.fbcdn.net/v/t1.0-1/p100x100/10400046_1463829200340110_7740717001636395235_n.jpg?_nc_cat=0&oh=8cd981a225ffcfc9568c9308d00006a2&oe=5B6AE5EA");
        MainFeedPost mainFeedPost = new MainFeedPost("Australians each eat 47 kilograms of chicken a year. Surely that's too much, not least because it's sad to see a special occasion meal relegated to cheap protein, eaten unthinkingly in nuggets and wraps, but also because few of those chooks are as delicious as the roasted chicken at Napier Quarter. Like all the meat there, it's carefully sourced and adoringly cooked, as though every bite matters, which it does.", "-one spoon caffe<br/>-one spoon jj ", "https://zululandobserver.co.za/wp-content/uploads/sites/56/2017/05/fap-09.jpg", "2018-04-07", user1);
        mainFeedPost.setLikeCounter(23);
        User user2 = new User("Elek", "Beviz", "Dezsi", "dezso@gmail.com", "1992-01-26", "asdasd", "2018-04-05", "https://s3.amazonaws.com/f6s-public/profiles/1383316_original.jpg");
        MainFeedPost mainFeedPost2 = new MainFeedPost("I find nothing unreasonable about paying $4 for Grain Bakery sourdough, $10 for a snacky bowl of lightly spiced polenta fingers, $24 for a light, summery vegetable risotto with lemon ricotta, or $14 for made-to-order crepes suzette. Australians each eat 47 kilograms of chicken a year. Surely that's too much, not least because it's sad to see a special occasion meal relegated to cheap protein, eaten unthinkingly in nuggets and wraps, but also because few of those chooks are as delicious as the roasted chicken at Napier Quarter. Like all the meat there, it's carefully sourced and adoringly cooked, as though every bite matters, which it does.", "-one spoon caffe<br/>-one spoon jj ", "http://www.idealmagazine.co.uk/wp-content/uploads/2017/08/The-Fishcake-Burger-at-Nipa-Thai-768x1153.jpg", "2018-04-07", user2);
        mainFeedPost2.setLikeCounter(150);
        MainFeedPost mainFeedPost3 = new MainFeedPost("Just ate burgers KEK", "kkk", "https://thumbs.dreamstime.com/b/indian-food-chicken-dum-biryani-close-up-dish-horizontal-table-110755818.jpg", "2018-04-07", user2);

        Comment comment2 = new Comment("Bro who cares", user1, mainFeedPost3);

        us.saveUser(user1);
        us.saveUser(user2);
        mfs.saveMainFeedPost(mainFeedPost);
        mfs.saveMainFeedPost(mainFeedPost2);
        mfs.saveMainFeedPost(mainFeedPost3);
        cs.initSave(comment2);


    }
}