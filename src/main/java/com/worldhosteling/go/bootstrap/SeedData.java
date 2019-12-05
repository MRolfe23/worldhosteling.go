package com.worldhosteling.go.bootstrap;

import com.worldhosteling.go.domain.Account;
import com.worldhosteling.go.domain.Hostel;
import com.worldhosteling.go.repository.AccountRepository;
import com.worldhosteling.go.repository.HostelRepository;
import com.worldhosteling.go.service.AccountService;
import com.worldhosteling.go.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private HostelRepository hostelRepository;

    @Autowired
    private HostelService hostelService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        generateAccountSeedData();
    }

    private void generateAccountSeedData() {
        // set main account
        Account account = new Account();
        account.setFirstName("Michael");
        account.setLastName("Rolfe");
        LocalDate dob = LocalDate.of(1991, 5, 23);
        System.out.println(dob);
        account.setBirthDate(dob);
        account.setUserName("MRolfe");
        account.setEmail("michael@rolfe.com");
        account.setAboutMe("This is my about me!");
        account.setAccountType("Developer Of WorldHosteling");
        account.setBackgroundPicture("This is the background pic to be found in file");
        account.setProfilePicture("This is the profile pic to be found in file");
        account.setPassword("Password");
        System.out.println(account.toString());

        // set friends for list
//        List<Account> friendsList = new ArrayList<>();
//        Account friend1 = new Account();
//        friend1.setFirstName("Geraldine");
//        friend1.setLastName("Del Rosario");
//        friend1.setBirthDate(LocalDate.of(1992,7,4));
//        friend1.setPassword("Password");
//        friend1.setEmail("michael@rolfe.com");
//        friend1.setUserName("GeralDaaaanng");
//        friendsList.add(friend1);
//        accountRepository.save(friend1);

//        Account friend2 = new Account();
//        friend2.setFirstName("Bipin");
//        friend2.setLastName("Butala");
//        friend2.setUserName("BipBip");
//        friend2.setEmail("michael@rolfe.com");
//        friend2.setPassword("Password");
//        friend2.setBirthDate(LocalDate.of(1991, 5, 23));
//        friendsList.add(friend2);
//        accountRepository.save(friend2);
//
//        Account friend3 = new Account();
//        friend3.setFirstName("Brad");
//        friend3.setLastName("Kangaroo");
//        friend3.setUserName("BearalRoll");
//        friend3.setBirthDate(LocalDate.of(1991, 5, 23));
//        friend3.setPassword("Password");
//        friend3.setEmail("brod@.com");
//        friendsList.add(friend3);
//        accountRepository.save(friend3);
//
//        account.setFriendList(friendsList);

        // set hostel list
//        List<Hostel> hostelList = new ArrayList<>();
//        Hostel hostel1 = new Hostel();
//        hostel1.setName("New York Hostel");
//        hostel1.setCity("New York");
//        hostel1.setCountry("USA");
//        hostel1.setDescription("This hostel is in New York, New York. So nice they named it twice.");
//        hostel1.setBannerImage("Banner Image location");
//        hostel1.setLatitude(1.11);
//        hostel1.setLongitude(2.22);
//        hostel1.setPrice(23.33);
//        hostel1.setRating(4);
//        hostel1.setRegion("East Coast America");
//
//        // set hostel picture list
//        List<String> hostelPicList = new ArrayList<>();
//        for (int x = 0; x < 5; x++ ) {
//            hostelPicList.add("hostel Picture: " + x);
//        }
//        hostel1.setHostelPictureList(hostelPicList);
//
//        // set hostel free list
//        List<String> freeList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            freeList.add("free amenity: " + i);
//        }
//        hostel1.setFreeList(freeList);
//
//        // set hostel general list
//        List<String> generalList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            generalList.add("general stuff: " + i);
//        }
//        hostel1.setGeneralList(generalList);
//
//        // set hostel service list
//        List<String> serviceList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            serviceList.add("Service: " + i);
//        }
//        hostel1.setServicesList(serviceList);
//
//        // set food list
//        List<String> foodList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            foodList.add("food/drink item: " + i);
//        }
//        hostel1.setFoodDrinkList(foodList);
//
//        // set Entertainment list
//        List<String> entertainmentList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            entertainmentList.add("entertainment option: " + i);
//        }



//        hostel1.setEntertainmentList(entertainmentList);
//        hostelList.add(hostel1);
//        System.out.println(hostel1.toString());
//        hostelRepository.save(hostel1);
//        account.setHostelList(hostelList);

        // SAVE
        Account savedAccount = accountRepository.save(account);
        System.out.println(savedAccount.toString());
//        // GET
//        Optional<Account> foundAccount = accountRepository.findById(account.getId());
//        System.out.println(foundAccount);
//
//        Iterable<Account> foundAccountBy =  accountRepository.findAll();
//        System.out.println(foundAccountBy);
//
//        // UPDATE
//        savedAccount.setUserName("MRWhom");
//        Account updatedAccount = accountRepository.save(savedAccount);

        // DELETE
//        String idToDelete = updatedAccount.getId();
//        accountRepository.deleteById(idToDelete);
//
//        System.out.println(accountRepository.findAll());
    }

}
