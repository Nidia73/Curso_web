package demo.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.example.demo.models.Post;

public interface PostRepository extends JpaRepository<Post,Long>{
    
}
