package br.ufsc.ine.ppgcc.controller;

import br.ufsc.ine.ppgcc.mapper.DocumentMapper;
import br.ufsc.ine.ppgcc.model.Document;
import br.ufsc.ine.ppgcc.service.implementation.DocumentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

public class DocumentControllerTest {

    private DocumentService service;
    private DocumentController controller;

    @Before
    public void setUp(){
        service = Mockito.mock(DocumentService.class);
        DocumentMapper mapper = Mockito.mock(DocumentMapper.class);
        controller = new DocumentController(service, mapper);
    }

    @Test
    public void getNoAnnotatedTest() {
        Document document = Document.builder().id("1").build();
        ResponseEntity<List<Document>> expected = ResponseEntity.ok(Collections.singletonList(document));
        when(service.getNoAnnotatedDocuments()).thenReturn(Collections.singletonList(document));

        ResponseEntity<List<Document>> actual = controller.getNoAnnotated();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAnnotatedTest(){
        LocalDateTime start = LocalDateTime.of(2017, Month.SEPTEMBER, 18, 0, 0);
        LocalDateTime finish = start.plusDays(1);

        Document document = Document.builder().id("1").build();
        ResponseEntity<List<Document>> expected = ResponseEntity.ok(Collections.singletonList(document));
        when(service.getAnnotatedDocumentsBetween(start, finish)).thenReturn(Collections.singletonList(document));

        ResponseEntity<List<Document>> actual = controller.getAnnotated(
                Date.from(start.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(finish.atZone(ZoneId.systemDefault()).toInstant()));

        Assert.assertEquals(expected, actual);
    }
}
