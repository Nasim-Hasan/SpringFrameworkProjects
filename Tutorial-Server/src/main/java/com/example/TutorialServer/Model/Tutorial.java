package com.example.TutorialServer.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private String published;

    public Tutorial(){}

    public Tutorial(String title, String description, String published) {
           this.title = title;
           this.description=description;
           this.published=published;
    }

}
