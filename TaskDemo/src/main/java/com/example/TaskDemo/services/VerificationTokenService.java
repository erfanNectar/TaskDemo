//package com.example.TaskDemo.services;
//
//import com.example.TaskDemo.Exception.TokenNotFoundException;
//import com.example.TaskDemo.models.User;
//import com.example.TaskDemo.models.VerificationToken;
//import com.example.TaskDemo.repository.UserRepository;
//import com.example.TaskDemo.repository.VerificationTokenRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Service
//public class VerificationTokenService {
//    @Value("${verification.token.expiryHours}")
//    private int expiryHours;
//    private final UserRepository userRepository;
//    private final VerificationTokenRepository verificationTokenRepository;
//
//
//
//    public VerificationTokenService(UserRepository userRepository, VerificationTokenRepository verificationTokenRepository) {
//        this.userRepository = userRepository;
//        this.verificationTokenRepository = verificationTokenRepository;
//    }
//
//    public VerificationToken generateVerificationToken(User user) {
//        VerificationToken verificationToken = new VerificationToken();
//        verificationToken.setToken(UUID.randomUUID().toString());
//        verificationToken.setUser(user);
//        verificationToken.setExpiryDate(LocalDateTime.now().plusHours(expiryHours));
//        verificationTokenRepository.save(verificationToken);
//        return verificationToken;
//    }
//
//
//    public User verifyUser(String token) {
//        VerificationToken verificationToken = (VerificationToken) verificationTokenRepository.findByToken(token)
//                .orElseThrow(() -> new TokenNotFoundException("Verification token not found"));
//
//        if (verificationToken.getExpiryDate().isBefore(LocalDateTime.now())) {
//            //  Token has expired
//            // You can handle token expiration logic here
//            // For now, let's just remove the token and return null
//            verificationTokenRepository.delete(verificationToken);
//            return null;
//        }
//
//        User user = verificationToken.getUser();
////        user.setUserStatus(UserStatus.VERIFIED);  // Set user status to VERIFIED
//        userRepository.save(user);
//        verificationTokenRepository.delete(verificationToken);  // Delete the token after verification
//
//        return user;
//    }
//}
