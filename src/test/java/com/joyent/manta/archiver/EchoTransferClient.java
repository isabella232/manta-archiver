/*
 * Copyright (c) 2017, Joyent, Inc. All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.joyent.manta.archiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * A {@link TransferClient} implementation used for testing that outputs
 * files transferred to STDOUT.
 */
class EchoTransferClient implements TransferClient {
    private static Logger LOG = LoggerFactory.getLogger(EchoTransferClient.class);

    @Override
    public Stream<FileDownload> find() {
        return null;
    }

    @Override
    public void mkdirp(final String path, final DirectoryUpload upload) {
        LOG.trace("mkdirp: {} --> {}", upload.getSourcePath(), path);
    }

    @Override
    public void put(final String path, final FileUpload upload) {
        LOG.trace("put:    {} --> {}", upload.getSourcePath(), path);
        upload.getTempPath().toFile().delete();
    }

    @Override
    public void put(final String path, final SymbolicLinkUpload upload) {

    }

    @Override
    public void delete(final String path, final boolean recursive) {

    }

    @Override
    public int getMaximumConcurrentConnections() {
        return 12;
    }

    @Override
    public String convertLocalPathToRemotePath(final Path sourcePath,
                                               final Path localRoot) {
        return "/remote" + localRoot;
    }

    @Override
    public Path convertRemotePathToLocalPath(final String remotePath, final Path localRoot) {
        return null;
    }

    @Override
    public String getRemotePath() {
        return "/remote/";
    }

    @Override
    public VerificationResult verifyDirectory(String remotePath) {
        return null;
    }

    @Override
    public VerificationResult verifyFile(String remotePath, long size, byte[] checksum) {
        return null;
    }

    @Override
    public VerificationResult verifyLink(final String remotePath, final Path localResolvedPath) {
        return null;
    }

    @Override
    public VerificationResult download(final String remotePath,
                                       final Optional<Path> path) {
        return null;
    }

    @Override
    public String get(final String remotePath) {
        return null;
    }

    @Override
    public void close() {
        // Do nothing
    }
}
