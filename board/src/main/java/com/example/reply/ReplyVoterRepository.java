package com.example.reply;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.User;

public interface ReplyVoterRepository extends JpaRepository<ReplyVoter, Long>{
	
	Optional<ReplyVoter> findByReplyAndUser(Reply reply, User user);
}
