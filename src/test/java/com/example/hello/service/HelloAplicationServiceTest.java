package com.example.hello.service;

import org.junit.jupiter.api.Test;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import com.example.hello.entity.Theme;

@SpringBootTest
public class HelloAplicationServiceTest {
    @Autowired
	HelloAplicationService themeMapper;
		
	@Test
	void testTheme() {
		List<Theme> themes = themeMapper.getTheme();
		assertThat(themes.size()).isEqualTo(3);
	}

}
