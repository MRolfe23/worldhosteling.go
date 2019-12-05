package com.worldhosteling.go.persistance_test;

import com.worldhosteling.go.WorldhostelingApplication;
import com.worldhosteling.go.domain.*;
import com.worldhosteling.go.repository.*;
import com.worldhosteling.go.service.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WorldhostelingApplication.class)
public class PostTest {

    //
    //  MAKE SURE THAT != AND .equals ARE CONSIDERED WHILE COMPARING
    //

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private NotificationPostRepository notificationPostRepository;

    @Autowired
    private NotificationPostService notificationPostService;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PhotoService photoService;

    public PostTest() {}

    @Test
    public void testPostRepository() {

        //region Account creation
        // set main account
        Account account = new Account();
        account.setFirstName("Michael");
        account.setLastName("Rolfe");
        account.setUserName("MRolfe");
        account.setAboutMe("This is my about me!");
        account.setAccountType("Developer Of WorldHosteling");
        account.setBackgroundPicture("This is the background pic to be found in file");
        account.setProfilePicture("This is the profile pic to be found in file");
        account.setPassword("Password");

        // set friends for list
        List<Account> friendsList = new ArrayList<>();
        Account friend1 = new Account();
        friend1.setFirstName("Geraldine");
        friend1.setLastName("Del Rosario");
        friend1.setUserName("GeralDaaaanng");
        friendsList.add(friend1);
        accountRepository.save(friend1);

        Account friend2 = new Account();
        friend2.setFirstName("Bipin");
        friend2.setLastName("Butala");
        friend2.setUserName("BipBip");
        friendsList.add(friend2);
        Account bip = accountRepository.save(friend2);

        Account friend3 = new Account();
        friend3.setFirstName("Brad");
        friend3.setLastName("Kangaroo");
        friend3.setUserName("BearalRoll");
        friendsList.add(friend3);
        accountRepository.save(friend3);

        account.setFriendList(friendsList);


        accountRepository.save(account);
        //endregion

        // creating post
        Post post = new Post();
        NotificationPost notificationPost1 = new NotificationPost();
        post.setContent("This is the first post ever!!");
        post.setFrom(account);
        post.setTo(friend1);
        notificationPost1.setFrom(account);
        notificationPost1.setTo(friend1);
        notificationPost1.setPost(post);

        // save post
        Post savedPost = postRepository.save(post);
        Assert.assertNotNull(savedPost.getId());
        NotificationPost savedNotificationPost = notificationPostRepository.save(notificationPost1);
        Assert.assertNotNull(savedNotificationPost.getId());

        System.out.println(post.toString());

        // creating list of photos to post (Can be null)
        List<Comment> commentsOnPost = new ArrayList<>();

        Comment newCommentGeraldine = new Comment();
        newCommentGeraldine.setContent("Then this has to be the very first comment!!!");
        newCommentGeraldine.setFrom(friend1);
        commentRepository.save(newCommentGeraldine);
        commentsOnPost.add(newCommentGeraldine);

        post.setCommentList(commentsOnPost);

        Post postWithComments = postRepository.save(post);
        NotificationPost notifyMichaelOfComment = new NotificationPost(newCommentGeraldine.getFrom(), post.getFrom(), post, false );
        notificationPostRepository.save(notifyMichaelOfComment);
        Assert.assertNotNull(notifyMichaelOfComment.getId());

        Comment anotherNewComment = new Comment();
        anotherNewComment.setFrom(bip);
        anotherNewComment.setContent("Wow, this is working great! the notifications must be on point too.");
        commentRepository.save(anotherNewComment);
        commentsOnPost.add(anotherNewComment);

        post.setCommentList(commentsOnPost);

        Post notifyCorrectPeople = postRepository.save(post);
        if (notifyCorrectPeople.getFrom() != bip) {
            NotificationPost notifyPostFrom = new NotificationPost();
            notifyPostFrom.setTo(notifyCorrectPeople.getFrom());
            notifyPostFrom.setFrom(bip);
            notifyPostFrom.setPost(notifyCorrectPeople);
            notifyPostFrom.setSeen(false);
            notificationPostRepository.save(notifyPostFrom);
        }
        if (notifyCorrectPeople.getTo() != bip) {
            NotificationPost notifyPostTo = new NotificationPost();
            notifyPostTo.setTo(notifyCorrectPeople.getTo());
            notifyPostTo.setFrom(bip);
            notifyPostTo.setPost(notifyCorrectPeople);
            notifyPostTo.setSeen(false);
            notificationPostRepository.save(notifyPostTo);
        }
        if (notifyCorrectPeople.getCommentList().size() > 0) {
            for ( Comment comment : notifyCorrectPeople.getCommentList()) {
                if (bip.equals(comment.getFrom()) && comment.getFrom() != notifyCorrectPeople.getFrom() && comment.getFrom() != notifyCorrectPeople.getTo()) {
                    NotificationPost notifyCommenter = new NotificationPost(bip,comment.getFrom(), notifyCorrectPeople, false );
                    System.out.println(bip.getUserName());
                    System.out.println(comment.getFrom().getUserName());
                    notificationPostRepository.save(notifyCommenter);
                }
            }
        }

        System.out.println(postWithComments.toString());

    }

    @Test
    public void testPostService() {

        //region Account creation
        // set main account
        Account account = new Account();
        account.setFirstName("Michael");
        account.setLastName("Rolfe");
        account.setUserName("MRolfe");
        account.setAboutMe("This is my about me!");
        account.setAccountType("Developer Of WorldHosteling");
        account.setBackgroundPicture("This is the background pic to be found in file");
        account.setProfilePicture("This is the profile pic to be found in file");
        account.setPassword("Password");

        // set friends for list
        List<Account> friendsList = new ArrayList<>();
        Account friend1 = new Account();
        friend1.setFirstName("Geraldine");
        friend1.setLastName("Del Rosario");
        friend1.setUserName("GeralDaaaanng");
        friendsList.add(friend1);
        accountService.saveAccount(friend1);

        Account friend2 = new Account();
        friend2.setFirstName("Bipin");
        friend2.setLastName("Butala");
        friend2.setUserName("BipBip");
        friendsList.add(friend2);
        Account bip = accountService.saveAccount(friend2);

        Account friend3 = new Account();
        friend3.setFirstName("Brad");
        friend3.setLastName("Kangaroo");
        friend3.setUserName("BearalRoll");
        friendsList.add(friend3);
        accountService.saveAccount(friend3);

        account.setFriendList(friendsList);


        accountService.saveAccount(account);
        //endregion

        // creating post
        Post post = new Post();
        NotificationPost notificationPost1 = new NotificationPost();
        post.setContent("This is the first post ever!!");
        post.setFrom(account);
        post.setTo(friend1);
        notificationPost1.setFrom(account);
        notificationPost1.setTo(friend1);
        notificationPost1.setPost(post);

        // save post
        Post savedPost = postRepository.save(post);
        Assert.assertNotNull(savedPost.getId());
        NotificationPost savedNotificationPost = notificationPostService.saveNotificationPost(notificationPost1);
        Assert.assertNotNull(savedNotificationPost.getId());

        System.out.println(post.toString());

        // creating list of photos to post (Can be null)
        List<Comment> commentsOnPost = new ArrayList<>();

        Comment newCommentGeraldine = new Comment();
        newCommentGeraldine.setContent("Then this has to be the very first comment!!!");
        newCommentGeraldine.setFrom(friend1);
        commentService.saveComment(newCommentGeraldine);
        commentsOnPost.add(newCommentGeraldine);

        post.setCommentList(commentsOnPost);

        Post postWithComments = postService.savePost(post);
        NotificationPost notifyMichaelOfComment = new NotificationPost(newCommentGeraldine.getFrom(), post.getFrom(), post, false );
        notificationPostService.saveNotificationPost(notifyMichaelOfComment);
        Assert.assertNotNull(notifyMichaelOfComment.getId());

        Comment anotherNewComment = new Comment();
        anotherNewComment.setFrom(bip);
        anotherNewComment.setContent("Wow, this is working great! the notifications must be on point too.");
        commentService.saveComment(anotherNewComment);
        commentsOnPost.add(anotherNewComment);

        post.setCommentList(commentsOnPost);

        Post notifyCorrectPeople = postService.savePost(post);
        if (notifyCorrectPeople.getFrom() != bip) {
            NotificationPost notifyPostFrom = new NotificationPost();
            notifyPostFrom.setTo(notifyCorrectPeople.getFrom());
            notifyPostFrom.setFrom(bip);
            notifyPostFrom.setPost(notifyCorrectPeople);
            notifyPostFrom.setSeen(false);
            notificationPostService.saveNotificationPost(notifyPostFrom);
        }
        if (notifyCorrectPeople.getTo() != bip) {
            NotificationPost notifyPostTo = new NotificationPost();
            notifyPostTo.setTo(notifyCorrectPeople.getTo());
            notifyPostTo.setFrom(bip);
            notifyPostTo.setPost(notifyCorrectPeople);
            notifyPostTo.setSeen(false);
            notificationPostService.saveNotificationPost(notifyPostTo);
        }
        if (notifyCorrectPeople.getCommentList().size() > 0) {
            for ( Comment comment : notifyCorrectPeople.getCommentList()) {
                if (bip.equals(comment.getFrom()) && comment.getFrom() != notifyCorrectPeople.getFrom() && comment.getFrom() != notifyCorrectPeople.getTo()) {
                    NotificationPost notifyCommenter = new NotificationPost(bip, comment.getFrom(), notifyCorrectPeople, false );
                    System.out.println(bip.getUserName());
                    System.out.println(comment.getFrom().getUserName());
                    notificationPostRepository.save(notifyCommenter);
                }
            }
        }

        System.out.println(postWithComments.toString());

    }

    @Test
    public void testPhotoRepositoryPost() {

        //region Account creation
        // set main account
        Account account = new Account();
        account.setFirstName("Michael");
        account.setLastName("Rolfe");
        account.setUserName("MRolfe");
        account.setAboutMe("This is my about me!");
        account.setAccountType("Developer Of WorldHosteling");
        account.setBackgroundPicture("This is the background pic to be found in file");
        account.setProfilePicture("This is the profile pic to be found in file");
        account.setPassword("Password");

        // set friends for list
        List<Account> friendsList = new ArrayList<>();
        Account friend1 = new Account();
        friend1.setFirstName("Geraldine");
        friend1.setLastName("Del Rosario");
        friend1.setUserName("GeralDaaaanng");
        friendsList.add(friend1);
        accountService.saveAccount(friend1);

        Account friend2 = new Account();
        friend2.setFirstName("Bipin");
        friend2.setLastName("Butala");
        friend2.setUserName("BipBip");
        friendsList.add(friend2);
        Account bip = accountService.saveAccount(friend2);

        Account friend3 = new Account();
        friend3.setFirstName("Brad");
        friend3.setLastName("Kangaroo");
        friend3.setUserName("BearalRoll");
        friendsList.add(friend3);
        accountService.saveAccount(friend3);

        account.setFriendList(friendsList);


        accountService.saveAccount(account);
        //endregion

        // creating post
        Post post = new Post();
        NotificationPost notificationPost1 = new NotificationPost();
        post.setContent("This is the first post ever!!");
        post.setFrom(account);
        post.setTo(friend1);

        // set photo list
        List<Photo> picList = new ArrayList<>();

        Photo photo1 = new Photo();
        photo1.setPhotoPath("AccountId/Photo/Post/PhotoNameAndOrId");
        photo1.setCaption("Day at the beach!");
        Photo savePic1 = photoRepository.save(photo1);
        picList.add(savePic1);

        Photo photo2 = new Photo();
        photo2.setPhotoPath("AccountId/Photo/Post/PhotoNameAndOrId");
        photo2.setCaption("Day in the Hills!");
        Photo savePic2 = photoRepository.save(photo2);
        picList.add(savePic2);

        Photo photo3 = new Photo();
        photo3.setPhotoPath("AccountId/Photo/Post/PhotoNameAndOrId");
        photo3.setCaption("Day in the Forest!");
        Photo savePic3 = photoRepository.save(photo3);
        picList.add(savePic3);

        post.setPhotoList(picList);

        System.out.println(picList.get(1));
        System.out.println(picList.get(2));
        System.out.println(picList.get(0));

        notificationPost1.setFrom(account);
        notificationPost1.setTo(friend1);
        notificationPost1.setPost(post);

        // save post
        Post savedPost = postRepository.save(post);
        Assert.assertNotNull(savedPost.getId());
        NotificationPost savedNotificationPost = notificationPostService.saveNotificationPost(notificationPost1);
        Assert.assertNotNull(savedNotificationPost.getId());

        System.out.println(post.toString());

    }

}