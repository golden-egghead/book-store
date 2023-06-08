package com.example.SuViet.model;


import lombok.*;

import jakarta.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Data
@Table(name = "tblRoles")
public class Role {
    @Column(columnDefinition = "ntext", nullable = false)
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    @Id
    @OneToOne
    @JoinColumn(name = "UserID")
    private User user;
}
