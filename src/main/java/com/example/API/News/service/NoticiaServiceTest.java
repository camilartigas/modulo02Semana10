package com.example.API.News.service;


import com.example.API.News.model.Noticia;
import com.example.API.News.repository.NoticiaRepository;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;
import java.util.Optional;




public class NoticiaServiceTest {

    @Mock
    private NoticiaRepository noticiaRepository;

    @InjectMocks
    private NoticiaService noticiaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllNoticias() {
        // Mock dos dados retornados pelo repositório
        List<Noticia> noticias = Collections.singletonList(new Noticia(1L, "Título", "Texto"));
        when(noticiaRepository.findAll()).thenReturn(noticias);

        List<Noticia> result = noticiaService.getAllNoticias();

        assertEquals(1, result.size());
        assertEquals("Título", result.get(0).getTitulo());
    }

    @Test
    public void testGetNoticiaById() {
        // Mock de uma notícia específica pelo ID
        Noticia noticia = new Noticia(1L, "Título", "Texto");
        when(noticiaRepository.findById(1L)).thenReturn(Optional.of(noticia));

        Noticia result = noticiaService.getNoticiaById(1L);

        assertEquals("Título", result.getTitulo());
    }

}
