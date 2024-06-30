package org.spt.member.member.member.controller.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.spt.member.member.member.usecase.create.CreateMemberUseCase;
import org.spt.member.member.member.usecase.create.CreateMemberUseCaseOutput;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class CreateMemberControllerTest {

    private final CreateMemberUseCase createMemberUseCase = Mockito.mock();
    private final String URI = "/member/v1/create-member";
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {

        final String email = "usadapekora@hololive.jp";
        final String password = "pekopekohahahaha";
        final String name = "usadapekora";
        final String expectResult = "{\"pk\":1}";
        CreateMemberRequest createMemberRequest = new CreateMemberRequest(email, password, name);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(createMemberRequest);
        CreateMemberUseCaseOutput createMemberUseCaseOutput = new CreateMemberUseCaseOutput();
        createMemberUseCaseOutput.setEmail(email);
        createMemberUseCaseOutput.setName(name);
        createMemberUseCaseOutput.setPk(1L);
        when(createMemberUseCase.createMember(any())).thenReturn(createMemberUseCaseOutput);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(URI).content(requestJson).contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String responseString = response.getContentAsString();
        Assertions.assertEquals(expectResult, responseString);
    }
}