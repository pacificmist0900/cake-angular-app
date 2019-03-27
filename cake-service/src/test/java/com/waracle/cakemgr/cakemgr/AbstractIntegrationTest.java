package com.waracle.cakemgr.cakemgr;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by prashantsharma on 24/03/2019.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles({"h2"})
@AutoConfigureTestEntityManager
@Transactional
public abstract class AbstractIntegrationTest {
}
