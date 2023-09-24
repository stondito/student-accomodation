package com.sg.studentaccommodation.entities.people;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sg.studentaccommodation.entities.Block;
import com.sg.studentaccommodation.entities.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Host extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfEntrance;

    private String username;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "block_id")
    private Block block;

    @OneToMany(mappedBy = "host")
    private Set<Student> students;

    @JsonManagedReference
    @OneToMany(mappedBy = "host")
    private List<Item> news;

    public void addItem(Item item) {
        if (this.news == null) {
            this.news = new ArrayList<>();
        }
        this.news.add(item);
    }
}
