package <%=packageName%>.web.rest;

import com.codahale.metrics.annotation.Timed;
import <%=packageName%>.repository.AuthorityRepository;
import <%=packageName%>.security.AuthoritiesConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.net.URISyntaxException;

/**
 * REST controller for authorities
 */
@RestController
@RequestMapping("/api/authority")
public class AuthorityRessource {

    private final Logger log = LoggerFactory.getLogger(AuthorityRessource.class);

    @Inject
    private AuthorityRepository authorityRepository;

    /**
     * GET  /getALL  : get all Authorities
     * <p>
     * Go through the Authorities repository and get all existing authorities
     * </p>
     *
     * @return the ResponseEntity with the authorities
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @GetMapping("/getAll")
    @Timed
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity<?> getAllAuthorities() throws URISyntaxException {
      return new ResponseEntity<>(authorityRepository.findAll(), HttpStatus.OK);
    }


}
