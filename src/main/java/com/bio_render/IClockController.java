package com.bio_render;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IClockController {

	@GetMapping(value = "/getrequest", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<?> getDeviceCommand(@RequestParam("SN") String serialNumber) {
		log.info("📥 Device polling from SN: {}", serialNumber);
        
		return ResponseEntity.ok("OK");
	}

	@PostMapping(value = "/cdata", consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> receiveCData(
			@RequestParam("SN") String serialNumber,
			@RequestParam("table") String table,
			@RequestBody String rawBody) {
		
		log.info("📥 Data received from device SN: {}", serialNumber);
		log.info("🗂 Table: {}", table);
        log.info("rawBody: {}", rawBody);
		log.info("📏 Payload size: {} bytes", rawBody != null ? rawBody.length() : 0);
		log.debug("📄 Raw body (first 500 chars):\n{}", rawBody != null && rawBody.length() > 500 ? rawBody.substring(0, 500) : rawBody);
		
		return ResponseEntity.ok("OK");
	}
}

