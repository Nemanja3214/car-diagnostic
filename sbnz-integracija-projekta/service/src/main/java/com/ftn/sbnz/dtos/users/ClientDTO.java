package com.ftn.sbnz.dtos.users;


import com.ftn.sbnz.model.models.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {
    private String name;
    private String lastName;
    private String phone;

    public static ClientDTO toDTO(Client client) {
        if(client == null)
            return null;
        return new ClientDTO(client.getName(), client.getLastName(), client.getPhone());
    }
}
