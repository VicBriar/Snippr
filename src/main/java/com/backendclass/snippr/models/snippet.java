package com.backendclass.snippr.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Snippet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="snippet")
    private String snippet;

    @Column(name="language")
    @Enumerated(EnumType.ORDINAL)
    private Lang language;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Snippet () {}

    public Snippet (String snippet, Lang language, User user) {
        this.snippet = snippet;
        this.language = language;
        this.user = user;
    }
}
