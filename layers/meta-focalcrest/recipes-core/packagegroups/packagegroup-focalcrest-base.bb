# SPDX-License-Identifier: MIT
# Copyright (c) 2026 Focalcrest

SUMMARY = "Focalcrest base system package group"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = "\
    ca-certificates \
    e2fsprogs-e2fsck \
    e2fsprogs-resize2fs \
    e2fsprogs-mke2fs \
    focalcrest-net-conf \
    focalcrest-rootfs-grow \
    focalcrest-usb-gadget \
    kmod \
    gptfdisk \
    libgpiod-tools \
    i2c-tools \
    mmc-utils \
    pciutils \
    devmem2 \
    evtest \
    dtc \
    htop \
    iotop \
    sysstat \
    lsof \
    strace \
    trace-cmd \
    tcpdump \
    iperf3 \
    socat \
    rsync \
    tmux \
    python3 \
    file \
    less \
    procps \
    psmisc \
    util-linux \
    iproute2 \
    ethtool \
    kernel-module-nls-utf8 \
"
