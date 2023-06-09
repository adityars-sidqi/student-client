package com.adityarahman.studentclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
@AutoConfigureStubRunner(ids = "com.adityarahman:student-service:+:8080", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class StudentClientTest {

    @Autowired
    private StudentClient studentClient;

    @Test
    void getStudent_forGivenStudent_isReturned()
    {
        //given
        Long id = 1L;

        //when
        Student student = studentClient.getStudent(id);

        //then
        then(student.getId()).isNotNull();
        then(student.getName()).isEqualTo("Mark");
        then(student.getGrade()).isEqualTo(10);
    }
}
