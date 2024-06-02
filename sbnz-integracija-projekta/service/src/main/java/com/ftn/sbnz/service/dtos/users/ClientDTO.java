package com.ftn.sbnz.service.dtos.users;


import com.ftn.sbnz.model.models.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {
    private Integer id;
    private String name;
    private String lastName;
    private String phone;

    public static ClientDTO toDTO(Client client) {
        if(client == null)
            return null;
        return new ClientDTO(client.getId(), client.getName(), client.getLastName(), client.getPhone());
    }
}
