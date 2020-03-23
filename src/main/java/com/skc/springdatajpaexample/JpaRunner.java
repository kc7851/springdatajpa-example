package com.skc.springdatajpaexample;

import com.skc.springdatajpaexample.Entity.Comment;
import com.skc.springdatajpaexample.Entity.CommentRepository;
import com.skc.springdatajpaexample.Entity.Post;
import com.skc.springdatajpaexample.Entity.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private KiChang kiChang;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Post post = new Post();
        post.setTitle("게시글 1");
        post.setDescription("본문");

        Comment comment = new Comment();
        comment.setDescription("댓글1");

        post.addComment(comment);

        postRepository.save(post);
        commentRepository.save(comment);

        System.out.println("==================================");
        System.out.println(kiChang.getName());
    }
}
