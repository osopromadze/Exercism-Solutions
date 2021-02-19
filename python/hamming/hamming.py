def distance(strand_a, strand_b):
    if len(strand_a) != len(strand_b):
        raise ValueError("strand lengths does not match")
    return sum(1 for(a, b) in zip(strand_a, strand_b) if a != b)
