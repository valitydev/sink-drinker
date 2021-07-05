package com.rbkmoney.sinkdrinker.repository;

import com.rbkmoney.sinkdrinker.config.AbstractDaoConfig;
import com.rbkmoney.sinkdrinker.domain.PayoutSnapshot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PayoutSnapshotRepositoryTest extends AbstractDaoConfig {

    @Autowired
    private PayoutSnapshotRepository payoutSnapshotRepository;

    @BeforeEach
    public void setUp() {
        super.setUp();
        PayoutSnapshot payoutSnapshot = new PayoutSnapshot("trap", "trap", 0);
        payoutSnapshotRepository.save(payoutSnapshot);
    }

    @Test
    public void shouldSaveAndGet() {
        String payoutId = generatePayoutId();
        PayoutSnapshot payoutSnapshot = new PayoutSnapshot(payoutId, payoutId, 0);
        payoutSnapshotRepository.save(payoutSnapshot);
        Optional<PayoutSnapshot> saved = payoutSnapshotRepository.findById(payoutId);
        assertThat(saved).isPresent();
        assertThat(saved.get().getSnapshot()).isEqualTo(payoutId);
    }
}
