package com.ltp.superstore;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ltp.superstore.repository.ItemRepository;
import com.ltp.superstore.service.SuperstoreService;

@RunWith(MockitoJUnitRunner.class)
public class SuperstoreServiceTest {

    @Mock
    private  ItemRepository itemRepository;

    @InjectMocks
    private SuperstoreService superstoreService;
    
}
