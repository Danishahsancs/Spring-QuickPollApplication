package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.domain.Poll;
import io.zipcoder.tc_spring_poll_application.exception.ResourceNotFoundException;
import io.zipcoder.tc_spring_poll_application.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class PollController {

    private final PollRepository pollRepository;

    @Autowired
    public PollController(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    // GET all polls
    @RequestMapping(value="/polls", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();
        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    // POST a new poll
    @RequestMapping(value="/polls", method=RequestMethod.POST)
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {

        poll = pollRepository.save(poll);

        // Build URI for the newly created poll
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(newPollUri);

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    // GET a single poll by ID
    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.GET)
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        Poll p = pollRepository.findOne(pollId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    // UPDATE a poll
    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        // Optionally, you could validate pollId matches poll.getId()
        verifyPoll(pollId);
        pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE a poll
    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        pollRepository.delete(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyPoll(Long pollId) {
    Poll poll = pollRepository.findOne(pollId);
    if (poll == null) {
        throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
    }
}

}
